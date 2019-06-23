package de.unikassel.vs.pdDebug;

import de.unikassel.vs.pdDebug.Beacon;
import org.capnproto.MessageBuilder;
import org.capnproto.MessageReader;
import org.capnproto.ReaderOptions;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

import static org.capnproto.ReaderOptions.DEFAULT_READER_OPTIONS;

public class CapnZeroStuff {

    public static void main(String[] args) {
        // write message
        org.capnproto.MessageBuilder msgBuilder = new MessageBuilder();

        Beacon.BeaconStruct.Builder beaconMsgBuilder = msgBuilder.initRoot(Beacon.BeaconStruct.factory);

        beaconMsgBuilder.setIp("224.0.0.1");
        beaconMsgBuilder.setPort((short) 5555);
        beaconMsgBuilder.setUuid(UUID.randomUUID().toString().getBytes());

        System.out.println(String.format("Message: Ip=%s, Port=%d, UUID=%s",
                beaconMsgBuilder.asReader().getIp().toString(),
                beaconMsgBuilder.asReader().getPort(),
                new String(beaconMsgBuilder.asReader().getUuid().toArray())));

        /*
        // read message
        //org.capnproto.MessageReader messageReader = new MessageReader(buffer, DEFAULT_READER_OPTIONS);
        ByteBuffer byteBuffer[] = new ByteBuffer[1];
        byteBuffer[0] = ByteBuffer.wrap(beaconMsgBuilder.toString().getBytes());
        MessageReader messageReader = new MessageReader(byteBuffer, DEFAULT_READER_OPTIONS);

        Beacon.BeaconStruct.Reader msg = messageReader.getRoot(Beacon.BeaconStruct.factory);
        System.out.println(String.format("Message: Ip=%s, Port=%d, UUID=%s", msg.getIp().toString(), msg.getPort(), msg.getUuid()));

         */


        System.out.println(beaconMsgBuilder.toString());
    }

}
