package de.unikassel.vs.pdDebug;


import junit.framework.Assert;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SendSerializedTest {

    Publisher pub;
    Subscriber sub;
    static final int testSize = 30;

    @BeforeEach
    public void before() {

        pub = new Publisher();
        sub = new Subscriber();
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

    private void testMessage(Publisher pub, Subscriber sub) {
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

}
