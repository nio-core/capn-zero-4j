package de.unikassel.vs.pdDebug.capnzero;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class Capnzero {

    public static native int sendMessage(Pointer socket, int commType, String topic, String message);
    public static native Pointer receiveSerializedMessage(Pointer socket, int commType);
    public static native void freeStr(Pointer str);

    static {
        // https://github.com/dasys-lab/capnzerowrapper/
        Native.register("capnzerowrapper");
    }
}
