package de.unikassel.vs.pdDebug;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import de.unikassel.vs.pdDebug.capnzero.Capnzero;
import de.unikassel.vs.pdDebug.libzmq.zmq_msg_t;

import static de.unikassel.vs.pdDebug.libzmq.LibZMQLibrary.*;

public class Publisher {

    static final boolean DEBUG = false;

    static final String UDP_ADDRESS = "224.0.0.1:5555";
    static final String TCP_ADDRESS = "127.0.0.1:5555";
    static final String IPC_ADDRESS = "128.0.0.1:5555";

    private CommType commType = CommType.UDP;
    private String groupName;
    private Pointer socket;
    private Pointer context;

    public static void main(String[] args) {

        IntByReference major = new IntByReference();
        IntByReference minor = new IntByReference();
        IntByReference patch = new IntByReference();
        INSTANCE.zmq_version(major, minor, patch);
        System.out.println("ZMQ Version: (" + major.getValue() + ", " + minor.getValue() + ", " + patch.getValue() + ")");

        Publisher pub = new Publisher();
        Subscriber sub = new Subscriber();
        //sub.setContext(pub.getContext());

        switch (pub.commType) {
            case UDP:
                pub.bind(pub.commType, UDP_ADDRESS);
                sub.subscribe(pub.commType, UDP_ADDRESS);
                break;
            case TCP:
                pub.bind(pub.commType, TCP_ADDRESS);
                sub.subscribe(pub.commType, TCP_ADDRESS);
                break;
            case IPC:
                pub.bind(pub.commType, IPC_ADDRESS);
                sub.subscribe(pub.commType, IPC_ADDRESS);
                break;
        }


        // Start Publisher and subscriber
        try {
            pub.start(10, false);
            Thread.sleep(100);
            sub.start(10, false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void start(final int frequenzy, final boolean serialized) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("Started Publisher");
                    for (int i = 0; i < frequenzy; i++) {
                        Thread.sleep(1000);

                        // send a message
                        if (serialized) {
                            sendSerializedMessage("Hallo " + i);
                        } else {
                            sendMessage("Hallo " + i);
                        }
                    }

                    destroy();
                    System.out.println("Closed Publisher");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
    }

    public Publisher() {
        this.context = INSTANCE.zmq_ctx_new();
        this.groupName = "TestGroupName";
    }

    public void destroy() {
        check(INSTANCE.zmq_close(socket), "zmq_close");
        check(INSTANCE.zmq_ctx_term(context), "zmq_ctx_term");
    }

    public void bind(CommType commType, String address) {
        this.commType = commType;
        switch (commType) {
            case UDP:
                socket = INSTANCE.zmq_socket(context, ZMQ_RADIO);
                check(INSTANCE.zmq_connect(socket, "udp://" + address), "zmq_connect");
                break;
            case TCP:
                socket = INSTANCE.zmq_socket(context, ZMQ_PUB);
                check(INSTANCE.zmq_bind(socket, "tcp://" + address), "zmq_bind");
                break;
            case IPC:
                socket = INSTANCE.zmq_socket(context, ZMQ_PUB);
                check(INSTANCE.zmq_bind(socket, "ipc://" + address), "zmq_bind");
                break;
            default:
                socket = null;
        }
    }


    public void sendMessage(String str) {
        zmq_msg_t msg = new zmq_msg_t();
        check(INSTANCE.zmq_msg_init(msg), "zmq_msg_init");
        Memory mem = new Memory(str.length() + 1);
        mem.setString(0, str);
        NativeSize size = new NativeSize(str.length());
        check(INSTANCE.zmq_msg_init_data(msg, mem, size, null, null), "zmq_msg_init_data");
        check(INSTANCE.zmq_msg_set_group(msg, groupName), "zmq_msg_set_group");
        System.out.print("(" + commType.toString() + ") Sending on Group \"" + groupName + "\": \"" + str + "\"");
        int bytes = INSTANCE.zmq_msg_send(msg, socket, 0);
        System.out.println(" (" + bytes + " bytes)" + (bytes < 0 ? "... FAILED" : "... OK"));
        check(INSTANCE.zmq_msg_close(msg), "zmq_msg_close");
    }

    public void sendSerializedMessage(String msg_send) {
        System.out.print("(" + commType.toString() + ") Sending on Group \"" + groupName + "\": \"" + msg_send + "\"");
        int numBytesSent = Capnzero.sendMessage(this.socket, this.commType.ordinal(), this.groupName, msg_send);
        System.out.println(" (" + numBytesSent + " bytes)" + (numBytesSent < 0 ? "... FAILED" : "... OK"));
    }

    private void check(int returnCode, String nameOfMethod) {
        if (DEBUG && returnCode == 0) {
            System.out.println(nameOfMethod + " returned: " + returnCode);
        }
        if (returnCode != 0) {
            System.err.println(nameOfMethod + " returned: " + returnCode);
        }
    }

    public Pointer getContext() {
        return context;
    }

    public void setContext(Pointer context) {
        this.context = context;
    }

    public Pointer getSocket() {
        return socket;
    }

    public CommType getCommType() {
        return commType;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
