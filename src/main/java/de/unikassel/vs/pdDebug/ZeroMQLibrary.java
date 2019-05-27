package de.unikassel.vs.pdDebug;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

public interface ZeroMQLibrary extends Library {

    int ZMQ_RADIO = 14;
    int ZMQ_DISH = 15;
    int ZMQ_RCVTIMEO = 27;

    ZeroMQLibrary INSTANCE = Native.load("libzmq", ZeroMQLibrary.class);

    void zmq_version(IntByReference major, IntByReference minor, IntByReference patch);

    PointerByReference zmq_ctx_new();

    PointerByReference zmq_socket(PointerByReference ctx, int type);

    int zmq_connect(PointerByReference ctx, String address);

    int zmq_setsockopt(PointerByReference socket, int option, IntByReference value, int valueLength);

    int zmq_join(PointerByReference socket, String groupName);

    int zmq_bind(PointerByReference socket, String address);

    int zmq_msg_init(Message msg);

    int zmq_msg_init_data(Message msg, PointerByReference data, int size, PointerByReference freeMethod, PointerByReference hint);

    PointerByReference zmq_msg_data(Message msg);

    int zmq_msg_size(Message msg);

    int zmq_msg_set_group(Message msg, String groupName);

    int zmq_msg_send(Message msg, PointerByReference socket, int flags);

    int zmq_msg_recv(Message msg, PointerByReference socket, int flags);

    int zmq_msg_close(Message msg);

    class Message extends Structure {
        public String _;

        public Message() {
            _ = "";
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("_");
        }
    }

}
