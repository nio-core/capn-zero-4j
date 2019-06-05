package de.unikassel.vs.pdDebug;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import de.unikassel.vs.pdDebug.libzmq.zmq_msg_t;

import static de.unikassel.vs.pdDebug.libzmq.LibZMQLibrary.*;

public class Subscriber {
    final boolean DEBUG = false;

    final String ADDRESS = "udp://224.0.0.1:5555";
    final String GROUPNAME = "TestGroupName";

    private Pointer ctx;

    Subscriber() {
        //this.ctx = INSTANCE.zmq_ctx_new();
    }

    public void subscribe() {
        IntByReference timeout = new IntByReference(500);
        NativeSize optValLen = new NativeSize(4);
        final Pointer sub_socket = INSTANCE.zmq_socket(ctx, ZMQ_DISH);
        check(INSTANCE.zmq_setsockopt(sub_socket, ZMQ_RCVTIMEO, timeout.getPointer(), optValLen), "zmq_setsockopt"); //TODO maybe not only 4
        check(INSTANCE.zmq_join(sub_socket, GROUPNAME), "zmq_join");
        check(INSTANCE.zmq_bind(sub_socket, ADDRESS), "zmq_bind");


        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Started Subscriber");

                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);

                        // Some errors :(

                        zmq_msg_t msg = new zmq_msg_t();
                        check(INSTANCE.zmq_msg_init(msg), "zmq_msg_init");
                        int bytes = INSTANCE.zmq_msg_recv(msg, sub_socket, 0);
                        System.out.print("bytes: " + bytes + " | ");
                        if (bytes > 0) {
                            Pointer data = INSTANCE.zmq_msg_data(msg);
                            NativeSize size = INSTANCE.zmq_msg_size(msg);
                            System.out.print("Received \"" + data.getString(0) + "\".");
                        }
                        System.out.println();
                        check(INSTANCE.zmq_msg_close(msg), "zmq_msg_close");
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
