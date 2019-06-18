package de.unikassel.vs.pdDebug.capnzero;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CapnZeroLibrary extends Library {

    CapnZeroLibrary INSTANCE = Native.load("capnzero", CapnZeroLibrary.class);

    void send();

}
