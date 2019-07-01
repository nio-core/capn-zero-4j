package de.unikassel.vs.pdDebug;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TCPTest {

    CommType type = CommType.TCP;
    String address = Publisher.TCP_ADDRESS;

    Publisher pub;
    Subscriber sub;
    TestTools util;

    static final int socketSize = 5;
    static final int testSize = 3;
    ArrayList<Subscriber> subList = new ArrayList<>();
    ArrayList<Publisher> pubList = new ArrayList<>();

    @BeforeEach
    public void before() {
        util = new TestTools();
        pub = new Publisher();
        pubList.add(pub);
        sub = new Subscriber();
        subList.add(sub);
        try {
            Thread.sleep(500);
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

        for (Subscriber sub : subList) {
            sub.term();
        }
        for (Publisher pub : pubList) {
            pub.term();
        }
        System.out.println();
    }

    @Test
    @Order(1)
    public void sendTest() {
        pub.bind(type, address);
        sub.subscribe(type, address);

        util.testMessage(pub, sub, testSize);
    }

    @Test
    @Order(2)
    public void sendSerializedTest() {
        pub.bind(type, address);
        sub.subscribe(type, address);

        util.testSerializedMessage(pub, sub, testSize);
    }

    @Test
    @Order(3)
    public void onePubManySubTest() {
        pubList.clear();
        subList.clear();
        util.testOnePubManySub(pubList, subList, socketSize, testSize, type, address);
    }
}
