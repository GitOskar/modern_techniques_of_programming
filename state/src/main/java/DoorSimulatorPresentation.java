import simulator.DoorSimulator;

public class DoorSimulatorPresentation {

    private static final int INTERVAL = 50;
    private static final int OPEN_DOOR_TIMEOUT = 4;

    public static void main(String[] args) throws InterruptedException {

        DoorSimulator doorSimulator = new DoorSimulator(INTERVAL, OPEN_DOOR_TIMEOUT);

        doorSimulator.open();

        Thread.sleep(10000);

        System.out.println("stop");
        doorSimulator.stop();

        Thread.sleep(5000);

        doorSimulator.close();

        Thread.sleep(2000);

        doorSimulator.open();
    }
}
