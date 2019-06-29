package de.unikassel.vs.pdDebug;

import junit.framework.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PubSubTest {

    Publisher pub;
    Subscriber sub;

    static final int socketSize = 100;
    static final int testSize = 2;
    ArrayList<Subscriber> subList = new ArrayList<>();
    ArrayList<Publisher> pubList = new ArrayList<>();

    @BeforeEach
    public void before() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterEach
    public void after() {
        for (Subscriber sub : subList) {
            sub.destroy();
        }
        for (Publisher pub : pubList) {
            pub.destroy();
        }
        System.out.println();
    }

    /**
     * test for 1 pub with socketSize subs. All share the same context
     * @param type
     * @param address
     */
    public void testOnePubManySub(CommType type, String address) {

        pub = new Publisher();
        pub.bind(type, address);
        pubList.add(pub);


        for (int i = 0; i < socketSize; i++) {
            sub = new Subscriber(pub.getContext());
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

    public void testOneSubManyPub(CommType type, String address) {

        sub = new Subscriber();
        subList.add(sub);

        for (int i = 0; i < socketSize; i++) {
            pub = new Publisher();
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

    @Test
    @Order(1)
    public void testTCP() {
        testOnePubManySub(CommType.TCP, Publisher.TCP_ADDRESS);
    }

    @Test
    @Order(2)
    public void testUPD() {
        System.out.println("One Sub Many Pub");
        testOneSubManyPub(CommType.UDP, Publisher.UDP_ADDRESS);
        System.out.println("One Pub Many Sub");
        testOnePubManySub(CommType.UDP, Publisher.UDP_ADDRESS);
    }

    @Test
    @Order(3)
    public void testIPC() {
        testOnePubManySub(CommType.IPC, Publisher.IPC_ADDRESS);
    }

}
