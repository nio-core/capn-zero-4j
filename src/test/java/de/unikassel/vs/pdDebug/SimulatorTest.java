package de.unikassel.vs.pdDebug;

import org.junit.jupiter.api.Test;

public class SimulatorTest {

    @Test
    public void testSendUDPMessages() throws InterruptedException {
        Subscriber sub = new Subscriber();
        sub.subscribe(Protocol.UDP, "224.0.0.2:5555");
        sub.setGroupName("ALICA");

        while(true) {
            System.out.print(sub.getMessage());
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) {
        Subscriber sub = new Subscriber();
        sub.setGroupName("AlicaEngineInfo");
        sub.subscribe(Protocol.UDP, "224.0.0.2:5555");

        System.out.println("Start listening to " + sub.getGroupName());

        while (true) {

            String msg = sub.getSerializedMessage();
            if (!msg.isEmpty()) {
                System.out.println("\n" + msg + "\n");
            } else {
                System.out.print(".");
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
