package de.unikassel.vs.pdDebug.capnzero;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import de.unikassel.vs.pdDebug.CommType;
import de.unikassel.vs.pdDebug.Publisher;

public class Capnzero {

    public static native int sendMessage(Pointer socket, int commType, String topic, String message);

    static {
        // only works if LD_LIBRARY_PATH includes /path/to/ros-ws/devel/lib
        // and libcapnzero.so is the updated shared object with the sendMessage-wrapper method
        Native.register("capnzero");
    }
}
