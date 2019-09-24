package de.unikassel.vs.pdDebug;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.Random;

public class TestTools {

    public void testOnePubManySub(ArrayList<Publisher> pubList, ArrayList<Subscriber> subList, int socketSize, int testSize, Protocol type, String address) {

        Publisher pub = new Publisher();
        pub.bind(type, address);
        pubList.add(pub);


        for (int i = 0; i < socketSize; i++) {
            Subscriber sub = new Subscriber(pub.getContext());
            sub.subscribe(type, address);
            subList.add(sub);
        }

        for (int i = 0; i < testSize; i++) {
            String toTest = TestTools.randomString();
            pub.sendMessage(toTest);

            int count = 1;
            for (Subscriber sub : subList) {
                System.out.print("Sub " + count++ + ": ");
                String msg = sub.getMessage();
                Assert.assertTrue(toTest.equals(msg));
            }
            System.out.println();
        }
    }

    public void testManyPubOneSub(ArrayList<Publisher> pubList, ArrayList<Subscriber> subList, int socketSize, int testSize, Protocol type, String address) {

        Subscriber sub = new Subscriber();
        subList.add(sub);

        for (int i = 0; i < socketSize; i++) {
            Publisher pub = new Publisher();
            pub.bind(type, address);
            pubList.add(pub);
        }

        sub.subscribe(type, address);

        for (int i = 0; i < testSize; i++) {

            for (Publisher pub : pubList) {
                String toTest = TestTools.randomString();
                pub.sendMessage(toTest);
                String msg = sub.getMessage();
                Assert.assertTrue(toTest.equals(msg));
            }

            System.out.println();
        }

    }

    public void testMessage(Publisher pub, Subscriber sub, int testSize) {
        for (int i = 0; i < testSize; i++) {
            try {
                String msg_send = TestTools.randomString();
                pub.sendMessage(msg_send);
                Thread.sleep(300);
                String msg_received = sub.getMessage();

                Assert.assertTrue(msg_send.equals(msg_received));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testSerializedMessage(Publisher pub, Subscriber sub, int testSize) {
        for (int i = 0; i < testSize; i++) {
            try {
                String msg_send = TestTools.randomString();
                pub.sendSerializedMessage(msg_send);
                Thread.sleep(300);
                String msg_received = sub.getSerializedMessage();

                Assert.assertTrue(msg_send.equals(msg_received));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    

    /**
     * generate a random String to send
     */
    public static String randomString() {
        int bound = new Random().nextInt(128) +1;
        return generateString(bound);
    }

    public static String randomGroupName() {
        return generateString(13);
    }

    /**
     * create a random String of length n
     */
    private static String generateString(int n)
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
