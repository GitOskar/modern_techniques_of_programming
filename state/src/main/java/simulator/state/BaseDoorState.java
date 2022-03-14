package simulator.state;

import simulator.DoorSimulator;

public abstract class BaseDoorState implements DoorState {

    protected final DoorSimulator doorSimulator;

    public BaseDoorState(DoorSimulator doorSimulator) {
        this.doorSimulator = doorSimulator;
    }
}
