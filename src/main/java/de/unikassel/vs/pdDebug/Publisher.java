package de.unikassel.vs.pdDebug;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public class Publisher {

    final boolean DEBUG = false;

    final String ADDRESS = "udp://localhost:5555";
    final String GROUPNAME = "TestGroupName";

    private PointerByReference ctx;

    public static void main(String[] args) {
        Publisher pub = new Publisher();
        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());

        //pub.publish();
        sub.subscribe();

    }

    Publisher() {
        IntByReference major = new IntByReference();
        IntByReference minor = new IntByReference();
        IntByReference patch = new IntByReference();
        ZeroMQLibrary.INSTANCE.zmq_version(major, minor, patch);
        this.ctx = ZeroMQLibrary.INSTANCE.zmq_ctx_new();
        System.out.println("ZMQ Version: (" + major.getValue() + ", " + minor.getValue() + ", " + patch.getValue() + ")");
    }

    public void publish() {
        final PointerByReference pub_socket = ZeroMQLibrary.INSTANCE.zmq_socket(ctx, ZeroMQLibrary.ZMQ_RADIO);
        check(ZeroMQLibrary.INSTANCE.zmq_connect(pub_socket, ADDRESS), "zmq_connect");

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Started Publisher");
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);

                        // publish a message
                        ZeroMQLibrary.Message msg = new ZeroMQLibrary.Message();
                        check(ZeroMQLibrary.INSTANCE.zmq_msg_init(msg), "zmq_msg_init");
                        PointerByReference data = new PointerByReference();
                        String str = "Hallo " + i; // TODO: > 8
                        Pointer pointer = data.getPointer();
                        pointer.setString(0, str);
                        check(ZeroMQLibrary.INSTANCE.zmq_msg_init_data(msg, data, str.length() + 1, null, null), "zmq_msg_init_data");
//                        check(ZeroMQLibrary.INSTANCE.zmq_msg_set_group(msg, GROUPNAME), "zmq_msg_set_group");
                        System.out.print("Sending on Group \"" + GROUPNAME + "\": \"" + str + "\"");
                        int bytes = ZeroMQLibrary.INSTANCE.zmq_msg_send(msg, pub_socket, 0);
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

    public PointerByReference getCtx() {
        return ctx;
    }

    public void setCtx(PointerByReference ctx) {
        this.ctx = ctx;
    }
}
