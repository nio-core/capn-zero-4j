package de.unikassel.vs.pdDebug;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.PointerUtils;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import de.unikassel.vs.pdDebug.libzmq.zmq_msg_t;

import static de.unikassel.vs.pdDebug.libzmq.LibZMQLibrary.ZMQ_RADIO;
import static de.unikassel.vs.pdDebug.libzmq.LibZMQLibrary.INSTANCE;

public class Publisher {

    final boolean DEBUG = false;

    final String ADDRESS = "udp://224.0.0.1:5555";
    final String GROUPNAME = "TestGroupName";

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

        pub.publish();
        sub.subscribe();

    }

    Publisher() {
        this.ctx = INSTANCE.zmq_ctx_new();
    }

    public void publish() {
        final Pointer pub_socket = INSTANCE.zmq_socket(ctx, ZMQ_RADIO);
        check(INSTANCE.zmq_connect(pub_socket, ADDRESS), "zmq_connect");

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Started Publisher");
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(1000);

                        // publish a message
                        zmq_msg_t msg = new zmq_msg_t();
                        check(INSTANCE.zmq_msg_init(msg), "zmq_msg_init");
                        String str = "Hallo " + i;
                        Memory mem = new Memory(str.length() + 1);
                        mem.setString(0, str);
                        NativeSize size = new NativeSize(str.length() + 1);
                        check(INSTANCE.zmq_msg_init_data(msg, mem, size, null, null), "zmq_msg_init_data");
                        check(INSTANCE.zmq_msg_set_group(msg, GROUPNAME), "zmq_msg_set_group");
                        System.out.print("Sending on Group \"" + GROUPNAME + "\": \"" + str + "\"");
                        int bytes = INSTANCE.zmq_msg_send(msg, pub_socket, 0);
                        System.out.println(" (" + bytes + " bytes)" + "... done");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
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
