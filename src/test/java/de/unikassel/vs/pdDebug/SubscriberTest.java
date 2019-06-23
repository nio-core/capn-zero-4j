package de.unikassel.vs.pdDebug;


import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class SubscriberTest {

    String toTest;

    @Before
    public void before() {
        int bound = new Random().nextInt(129);
        toTest = generateString(bound);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        System.out.println();
    }



    @Test
    public void testTCP() {


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
    public void testUPD() {

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
    public void testIPC() {

        //build publisher with IPC
        Publisher pub = new Publisher();
        pub.publish(CommType.IPC, Publisher.IPC_ADDRESS);

        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());
        sub.subscribe(CommType.IPC, Publisher.IPC_ADDRESS);

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
