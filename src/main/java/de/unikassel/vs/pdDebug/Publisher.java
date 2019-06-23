package de.unikassel.vs.pdDebug;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import de.unikassel.vs.pdDebug.libzmq.zmq_msg_t;
import org.capnproto.MessageBuilder;

import java.nio.ByteBuffer;
import java.util.UUID;

import static de.unikassel.vs.pdDebug.libzmq.LibZMQLibrary.*;

public class Publisher {

    static final boolean DEBUG = false;

    static final CommType COMM_TYPE = CommType.IPC;
    static final String UDP_ADDRESS = "224.0.0.1:5555";
    static final String TCP_ADDRESS = "127.0.0.1:5555";
    static final String GROUPNAME = "TestGroupName";

    private Pointer ctx;

    public static void main(String[] args) {

        IntByReference major = new IntByReference();
        IntByReference minor = new IntByReference();
        IntByReference patch = new IntByReference();
        INSTANCE.zmq_version(major, minor, patch);
        System.out.println("ZMQ Version: (" + major.getValue() + ", " + minor.getValue() + ", " + patch.getValue() + ")");

        Publisher pub = new Publisher();
        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());

        switch (COMM_TYPE) {
            case UDP:
                pub.publish(COMM_TYPE, UDP_ADDRESS);
                sub.subscribe(COMM_TYPE, UDP_ADDRESS);
                break;
            case TCP:
                pub.publish(COMM_TYPE, TCP_ADDRESS);
                sub.subscribe(COMM_TYPE, TCP_ADDRESS);
                break;
            case IPC:
                pub.publish(COMM_TYPE, TCP_ADDRESS);
                sub.subscribe(COMM_TYPE, TCP_ADDRESS);
                break;
        }

    }

    Publisher() {
        this.ctx = INSTANCE.zmq_ctx_new();
    }

    public void publish(CommType commType, String address) {
        final Pointer pub_socket;
        switch (commType) {
            case UDP:
                pub_socket = INSTANCE.zmq_socket(ctx, ZMQ_RADIO);
                check(INSTANCE.zmq_connect(pub_socket, "udp://" + address), "zmq_connect");
                break;
            case TCP:
                pub_socket = INSTANCE.zmq_socket(ctx, ZMQ_PUB);
                check(INSTANCE.zmq_bind(pub_socket, "tcp://" + address), "zmq_bind");
                break;
            case IPC:
                pub_socket = INSTANCE.zmq_socket(ctx, ZMQ_PUB);
                check(INSTANCE.zmq_bind(pub_socket, "ipc://" + address), "zmq_bind");
                break;
            default:
                pub_socket = null;
        }


        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Started Publisher");
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(1000);

                        // publish a message
                        //sendMessage1(pub_socket, "Hallo " + i);
                        sendMessage2(i);

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
    }

    private void sendMessage1(Pointer socket, String str) {
        zmq_msg_t msg = new zmq_msg_t();
        check(INSTANCE.zmq_msg_init(msg), "zmq_msg_init");
        Memory mem = new Memory(str.length() + 1);
        mem.setString(0, str);
        NativeSize size = new NativeSize(str.length() + 1);
        check(INSTANCE.zmq_msg_init_data(msg, mem, size, null, null), "zmq_msg_init_data");
        check(INSTANCE.zmq_msg_set_group(msg, GROUPNAME), "zmq_msg_set_group");
        System.out.print("Sending on Group \"" + GROUPNAME + "\": \"" + str + "\"");
        int bytes = INSTANCE.zmq_msg_send(msg, socket, 0);
        System.out.println(" (" + bytes + " bytes)" + "... done");
    }

    private void sendMessage2(int i) {
        // TODO capnproto message send. MsgBuilder -> Pointer (?)
        org.capnproto.MessageBuilder msgBuilder = new MessageBuilder();

        de.unikassel.vs.pdDebug.Beacon.BeaconStruct.Builder beaconMsgBuilder = msgBuilder.initRoot(de.unikassel.vs.pdDebug.Beacon.BeaconStruct.factory);

        beaconMsgBuilder.setIp("224.0.0.1");
        beaconMsgBuilder.setPort((short) i);
        beaconMsgBuilder.setUuid(UUID.randomUUID().toString().getBytes());

        ByteBuffer[] segmentsForOutput = msgBuilder.getSegmentsForOutput();
        zmq_msg_t msg = new zmq_msg_t();
        check(INSTANCE.zmq_msg_init(msg), "zmq_msg_init");
        Memory mem = new Memory(64);
        check(INSTANCE.zmq_msg_init_data(msg, mem, new NativeSize(64), null, null), "zmq_msg_init_data");

    }

    private void check(int returnCode, String nameOfMethod) {
        if (DEBUG && returnCode == 0) {
            System.out.println(nameOfMethod + " returned: " + returnCode);
        }
        if (returnCode != 0) {
            System.err.println(nameOfMethod + " returned: " + returnCode);
        }
    }

    public Pointer getCtx() {
        return ctx;
    }

    public void setCtx(Pointer ctx) {
        this.ctx = ctx;
    }
}
