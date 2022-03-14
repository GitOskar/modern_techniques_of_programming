package simulator.state;

import lombok.SneakyThrows;
import simulator.DoorSimulator;

public class ClosingDoor extends BaseDoorState {

    public ClosingDoor(DoorSimulator doorSimulator) {
        super(doorSimulator);
    }

    @SneakyThrows
    @Override
    public void open() {
        stop();
        Thread.sleep(100);
        this.doorSimulator.setDoorState(new OpeningDoor(doorSimulator));
        this.doorSimulator.getDoorEngine()
                .startOpening();
    }

    @Override
    public void stop() {
        this.doorSimulator.getDoorEngine()
                .stop();
    }

    @Override
    @SneakyThrows
    public void close() {
        stop();
        Thread.sleep(100);
        this.doorSimulator.getDoorEngine()
                .startClosing();
    }

    @Override
    public void start() {
        // do nothing
    }
}
