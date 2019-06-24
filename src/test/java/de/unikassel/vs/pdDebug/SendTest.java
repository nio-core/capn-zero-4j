package de.unikassel.vs.pdDebug;


import junit.framework.Assert;
import org.junit.jupiter.api.*;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SendTest {

    String toTest;

    @BeforeEach
    public void before() {
        int bound = new Random().nextInt(129);
        toTest = generateString(bound);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void after() {
        System.out.println();
    }



    @Test
    @Order(1)
    public void testTCP() {


        //build publisher with TCP
        Publisher pub = new Publisher();
        pub.publish(CommType.TCP, Publisher.TCP_ADDRESS);

        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());
        sub.subscribe(CommType.TCP, Publisher.TCP_ADDRESS);

        testMessage(pub, sub);
    }

    @Test
    @Order(2)
    public void testUPD() {

        //build publisher with UDP
        Publisher pub = new Publisher();
        pub.publish(CommType.UDP, Publisher.UDP_ADDRESS);

        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());
        sub.subscribe(CommType.UDP, Publisher.UDP_ADDRESS);

        testMessage(pub, sub);
    }

    @Test
    @Order(3)
    public void testIPC() {

        //build publisher with IPC
        Publisher pub = new Publisher();
        pub.publish(CommType.IPC, Publisher.IPC_ADDRESS);

        Subscriber sub = new Subscriber();
        sub.setCtx(pub.getCtx());
        sub.subscribe(CommType.IPC, Publisher.IPC_ADDRESS);

        testMessage(pub, sub);
    }

    private void testMessage(Publisher pub, Subscriber sub) {
        String msg_send = toTest;
        pub.sendMessage(msg_send);
        String msg_received = sub.getMessage();

        Assert.assertTrue(msg_send.equals(msg_received));
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
