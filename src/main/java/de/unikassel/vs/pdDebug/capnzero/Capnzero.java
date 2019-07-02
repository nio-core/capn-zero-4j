package de.unikassel.vs.pdDebug.capnzero;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class Capnzero {

    public static native int sendMessage(Pointer socket, int commType, String topic, String message);
    public static native String receiveSerializedMessage(Pointer socket, int commType);

    static {
        // only works if LD_LIBRARY_PATH includes /path/to/ros-ws/devel/lib and you have
        // built the catkin-workspace with capnzerowrapper included.
        // https://github.com/xlink9x/capnzerowrapper/
        Native.register("capnzerowrapper");
    }
}
