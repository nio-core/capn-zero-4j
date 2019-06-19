package de.unikassel.vs.pdDebug;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.sun.jna.Memory;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import de.unikassel.vs.pdDebug.libzmq.zmq_msg_t;

import static de.unikassel.vs.pdDebug.libzmq.LibZMQLibrary.*;

public class Subscriber {
    final boolean DEBUG = false;

    final String GROUPNAME = "TestGroupName";

    private Pointer ctx;

    Subscriber() {
        //this.ctx = INSTANCE.zmq_ctx_new();
    }

    public void subscribe(CommType commType, String address) {
        final Pointer sub_socket;

        IntByReference timeout = new IntByReference(500);
        NativeSize optValLen = new NativeSize(4);

        String emptyString = "";
        Pointer m = new Memory(emptyString.length() + 1); // WARNING: assumes ascii-only string
        m.setString(0, emptyString);
        NativeSize optValLenM = new NativeSize(0);

        switch (commType) {
            case UDP:
                sub_socket = INSTANCE.zmq_socket(ctx, ZMQ_DISH);
                check(INSTANCE.zmq_setsockopt(sub_socket, ZMQ_RCVTIMEO, timeout.getPointer(), optValLen), "zmq_setsockopt");
                check(INSTANCE.zmq_join(sub_socket, GROUPNAME), "zmq_join");
                check(INSTANCE.zmq_bind(sub_socket, "udp://" + address), "zmq_bind");
                break;
            case TCP:
                sub_socket = INSTANCE.zmq_socket(ctx, ZMQ_SUB);
                check(INSTANCE.zmq_setsockopt(sub_socket, ZMQ_RCVTIMEO, timeout.getPointer(), optValLen), "zmq_setsockopt");
                check(INSTANCE.zmq_setsockopt(sub_socket, ZMQ_SUBSCRIBE, m, optValLenM), "zmq_setsockopt");
                check(INSTANCE.zmq_connect(sub_socket, "tcp://" + address), "zmq_connect");
                break;
            case IPC:
                sub_socket = INSTANCE.zmq_socket(ctx, ZMQ_SUB);
                check(INSTANCE.zmq_setsockopt(sub_socket, ZMQ_RCVTIMEO, timeout.getPointer(), optValLen), "zmq_setsockopt");
                check(INSTANCE.zmq_setsockopt(sub_socket, ZMQ_SUBSCRIBE, m, optValLenM), "zmq_setsockopt");
                check(INSTANCE.zmq_connect(sub_socket, "ipc://" + address), "zmq_connect");
                break;
            default:
                sub_socket = null;
        }


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
