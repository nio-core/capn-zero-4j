package de.unikassel.vs.pdDebug.capnzero;

import com.sun.jna.NativeLibrary;

import static de.unikassel.vs.pdDebug.capnzero.CapnZeroLibrary.INSTANCE;

public class CapnZeroMessageTest {

    public static void main(String[] args) {

        NativeLibrary.addSearchPath("capnzero", "/opt/pd-debug/ros-ws/install");

        System.out.print("sending using capnzero...");
        INSTANCE.send();
        System.out.println(" success.");
    }

}
