package simulator.client;

import simulator.DoorSimulator;

public interface Client {

    void buttonPressed(DoorSimulator door);

    void sensor1Reached(DoorSimulator door);

    void sensor2Reached(DoorSimulator door);

    void doorLine(DoorSimulator door);
}