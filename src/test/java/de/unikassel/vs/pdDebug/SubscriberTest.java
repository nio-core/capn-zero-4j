package de.unikassel.vs.pdDebug;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

public class SubscriberTest {

    String toTest;

    @Before
    public void publish() {
        int bound = new Random().nextInt(129);
        toTest = generateString(bound);
    }

    @Test
    public void testUPD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //build publisher with UDP
        Publisher pub = new Publisher();
        pub.publish(CommType.UDP, Publisher.UDP_ADDRESS);

        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());
        sub.subscribe(CommType.UDP, Publisher.UDP_ADDRESS);

        String msg_send = toTest;
        pub.sendMessage(msg_send);
        String msg_recieved = sub.getMessage();

        Assert.assertTrue(msg_send.equals(msg_recieved));

    }

    @Test
    public void testTCP() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //build publisher with TCP
        Publisher pub = new Publisher();
        pub.publish(CommType.TCP, Publisher.TCP_ADDRESS);

        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());
        sub.subscribe(CommType.TCP, Publisher.TCP_ADDRESS);

        String msg_send = toTest;
        pub.sendMessage(msg_send);
        String msg_recieved = sub.getMessage();

        Assert.assertTrue(msg_send.equals(msg_recieved));


    }

    @Test
    public void testIPC() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //build publisher with IPC
        Publisher pub = new Publisher();
        pub.publish(CommType.IPC, Publisher.TCP_ADDRESS);

        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());
        sub.subscribe(CommType.IPC, Publisher.TCP_ADDRESS);

        String msg_send = toTest;
        pub.sendMessage(msg_send);
        String msg_recieved = sub.getMessage();

        Assert.assertTrue(msg_send.equals(msg_recieved));

    }

    /**
     * create a random String of length n
     */
    public static String generateString(int n)
    {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}
