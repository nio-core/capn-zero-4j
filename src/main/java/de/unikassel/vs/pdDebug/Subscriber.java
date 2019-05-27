package de.unikassel.vs.pdDebug;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public class Subscriber {
    final boolean DEBUG = false;

    final String ADDRESS = "udp://localhost:5555";
    final String GROUPNAME = "TestGroupName";

    private PointerByReference ctx;

    Subscriber() {
        IntByReference major = new IntByReference();
        IntByReference minor = new IntByReference();
        IntByReference patch = new IntByReference();
        ZeroMQLibrary.INSTANCE.zmq_version(major, minor, patch);
        this.ctx = ZeroMQLibrary.INSTANCE.zmq_ctx_new();
        System.out.println("ZMQ Version: (" + major.getValue() + ", " + minor.getValue() + ", " + patch.getValue() + ")");
    }

    public void subscribe() {
        IntByReference timeout = new IntByReference(500);
        final PointerByReference sub_socket = ZeroMQLibrary.INSTANCE.zmq_socket(ctx, ZeroMQLibrary.ZMQ_DISH);
        check(ZeroMQLibrary.INSTANCE.zmq_setsockopt(sub_socket, ZeroMQLibrary.ZMQ_RCVTIMEO, timeout, 4), "zmq_setsockopt"); //TODO maybe not only 4
        //     check(ZeroMQLibrary.INSTANCE.zmq_join(sub_socket, GROUPNAME), "zmq_join");
        check(ZeroMQLibrary.INSTANCE.zmq_bind(sub_socket, "udp://*:5555"), "zmq_bind");


        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Started Subscriber");

                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);

                        // Some errors :(

                        ZeroMQLibrary.Message msg = new ZeroMQLibrary.Message();
                        check(ZeroMQLibrary.INSTANCE.zmq_msg_init(msg), "zmq_msg_init");
                        int bytes = ZeroMQLibrary.INSTANCE.zmq_msg_recv(msg, sub_socket, 0);
                        System.out.print("bytes: " + bytes + " | ");
                        if (bytes > 0) {
                            PointerByReference data = ZeroMQLibrary.INSTANCE.zmq_msg_data(msg);
                            int size = ZeroMQLibrary.INSTANCE.zmq_msg_size(msg);
                            System.out.print("Received \"" + "\".");
                        }
                        System.out.println();
                        check(ZeroMQLibrary.INSTANCE.zmq_msg_close(msg), "zmq_msg_close");
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

    public PointerByReference getCtx() {
        return ctx;
    }

    public void setCtx(PointerByReference ctx) {
        this.ctx = ctx;
    }
}
