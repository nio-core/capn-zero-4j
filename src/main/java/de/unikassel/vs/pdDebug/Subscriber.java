package de.unikassel.vs.pdDebug;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import de.unikassel.vs.pdDebug.libzmq.zmq_msg_t;

import static de.unikassel.vs.pdDebug.libzmq.LibZMQLibrary.*;


public class Subscriber {
    final boolean DEBUG = false;

    private CommType commType = CommType.UDP;
    private String groupName = "TestGroupName";
    private Pointer socket;
    private Pointer context;

    Subscriber() {
        this(INSTANCE.zmq_ctx_new());
    }

    Subscriber(Pointer context) {
        this.context = context;
    }

    public void destroy() {
        check(INSTANCE.zmq_close(socket), "zmq_close");
    }

    public void term() {
        check(INSTANCE.zmq_ctx_term(context), "zmq_ctx_term");
    }

    public void subscribe(CommType commType, String address) {
        this.commType = commType;

        IntByReference timeout = new IntByReference(500);
        NativeSize optValLen = new NativeSize(4);

        String emptyString = "";
        Pointer m = new Memory(emptyString.length() + 1); // WARNING: assumes ascii-only string
        m.setString(0, emptyString);
        NativeSize optValLenM = new NativeSize(0);

        switch (commType) {
            case UDP:
                socket = INSTANCE.zmq_socket(context, ZMQ_DISH);
                check(INSTANCE.zmq_setsockopt(socket, ZMQ_RCVTIMEO, timeout.getPointer(), optValLen), "zmq_setsockopt");
                check(INSTANCE.zmq_join(socket, groupName), "zmq_join");
                check(INSTANCE.zmq_bind(socket, "udp://" + address), "zmq_bind");
                break;
            case TCP:
                socket = INSTANCE.zmq_socket(context, ZMQ_SUB);
                check(INSTANCE.zmq_setsockopt(socket, ZMQ_RCVTIMEO, timeout.getPointer(), optValLen), "zmq_setsockopt");
                check(INSTANCE.zmq_setsockopt(socket, ZMQ_SUBSCRIBE, m, optValLenM), "zmq_setsockopt");
                check(INSTANCE.zmq_connect(socket, "tcp://" + address), "zmq_connect");
                break;
            case IPC:
                socket = INSTANCE.zmq_socket(context, ZMQ_SUB);
                check(INSTANCE.zmq_setsockopt(socket, ZMQ_RCVTIMEO, timeout.getPointer(), optValLen), "zmq_setsockopt");
                check(INSTANCE.zmq_setsockopt(socket, ZMQ_SUBSCRIBE, m, optValLenM), "zmq_setsockopt");
                check(INSTANCE.zmq_connect(socket, "ipc://" + address), "zmq_connect");
                break;
            default:
                socket = null;
        }


    }

    public void start(final int frequenzy, final boolean serialized) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {

                try {
                    System.out.println("Started Subscriber");
                    for (int i = 0; i < frequenzy; i++) {
                        Thread.sleep(1000);

                        if (serialized) {
                            getSerializedMessage();
                        } else {
                            getMessage();
                        }
                    }

                    // wait to receive the last messages
                    Thread.sleep(frequenzy);
                    destroy();
                    System.out.println("Closed Subscriber");
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

    //TODO Receive serialized String
    public String getSerializedMessage() {
        return "";
    }

    public String getMessage() {

        String msg_str = "";
        zmq_msg_t msg = new zmq_msg_t();
        check(INSTANCE.zmq_msg_init(msg), "zmq_msg_init");

        int bytes = INSTANCE.zmq_msg_recv(msg, socket, 0);

        System.out.print("bytes: " + bytes + " | ");
        if (bytes > 0) {
            Pointer data = INSTANCE.zmq_msg_data(msg);
            NativeSize size = INSTANCE.zmq_msg_size(msg);
            msg_str = data.getString(0).substring(0, size.intValue());
            System.out.print("Received \"" + msg_str + "\".");
        }
        System.out.println();
        check(INSTANCE.zmq_msg_close(msg), "zmq_msg_close");

        return msg_str;
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
