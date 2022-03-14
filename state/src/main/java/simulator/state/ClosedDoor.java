package simulator.state;

import simulator.DoorSimulator;

public class ClosedDoor extends BaseDoorState {

    public ClosedDoor(DoorSimulator doorSimulator) {
        super(doorSimulator);
    }

    @Override
    public void open() {
        doorSimulator.getDoorEngine()
                .startOpening();
        doorSimulator.setDoorState(new OpeningDoor(doorSimulator));
    }

    @Override
    public void stop() {
        // nothing to do
    }

    @Override
    public void close() {
        // nothing to do
    }

    @Override
    public void start() {
        // nothing to do
    }
}
