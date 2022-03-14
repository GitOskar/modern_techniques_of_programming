package simulator.state;

import simulator.DoorSimulator;

public class OpeningDoor extends BaseDoorState {

    public OpeningDoor(DoorSimulator doorSimulator) {
        super(doorSimulator);
    }

    @Override
    public void open() {
        stop();
        this.doorSimulator.getDoorEngine()
                .startOpening();
    }

    @Override
    public void stop() {
        this.doorSimulator.getDoorEngine()
                .stop();
    }

    @Override
    public void close() {
        stop();
        this.doorSimulator.setDoorState(new ClosingDoor(doorSimulator));
        this.doorSimulator.getDoorEngine()
                .startClosing();
    }

    @Override
    public void start() {
        // nothing to do
    }
}
