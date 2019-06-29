package de.unikassel.vs.pdDebug;


import junit.framework.Assert;
import org.junit.jupiter.api.*;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SendTest {

    Publisher pub;
    Subscriber sub;
    String toTest;

    @BeforeEach
    public void before() {

        pub = new Publisher();
        sub = new Subscriber();

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
        pub.destroy();
        sub.destroy();
        System.out.println();
    }



    @Test
    @Order(1)
    public void testTCP() {
        //build publisher with TCP
        pub.bind(CommType.TCP, Publisher.TCP_ADDRESS);
        sub.subscribe(CommType.TCP, Publisher.TCP_ADDRESS);

        testMessage(pub, sub);
    }

    @Test
    @Order(2)
    public void testUPD() {
        //build publisher with UDP
        pub.bind(CommType.UDP, Publisher.UDP_ADDRESS);
        sub.subscribe(CommType.UDP, Publisher.UDP_ADDRESS);

        testMessage(pub, sub);
    }

    @Test
    @Order(3)
    public void testIPC() {
        //build publisher with IPC
        pub.bind(CommType.IPC, Publisher.IPC_ADDRESS);
        sub.subscribe(CommType.IPC, Publisher.IPC_ADDRESS);

        testMessage(pub, sub);
    }

    private void testMessage(Publisher pub, Subscriber sub) {
        try {
            String msg_send = toTest;
            pub.sendMessage(msg_send);
            Thread.sleep(300);
            String msg_received = sub.getMessage();

            Assert.assertTrue(msg_send.equals(msg_received));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
