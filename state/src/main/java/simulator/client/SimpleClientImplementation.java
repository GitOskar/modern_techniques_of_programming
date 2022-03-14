package simulator.client;

import simulator.DoorSimulator;

public class SimpleClientImplementation implements Client {

    @Override
    public void buttonPressed(DoorSimulator door) {
        door.open();
    }

    @Override
    public void sensor1Reached(DoorSimulator door) {
        door.open();
    }

    @Override
    public void sensor2Reached(DoorSimulator door) {
        door.close();
    }

    @Override
    public void doorLine(DoorSimulator door) {
        door.stop();
    }
}
