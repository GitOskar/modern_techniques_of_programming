package simulator;

import lombok.Data;
import simulator.engine.DoorEngine;
import simulator.state.ClosedDoor;
import simulator.state.DoorState;

@Data
public class DoorSimulator implements DoorState {

    private final int openDoorTimeout;
    private int openingPercentage;
    private final DoorEngine doorEngine;
    private DoorState doorState;

    public DoorSimulator(int interval, int openDoorTimeout) {
        this.openingPercentage = 0;
        this.doorState = new ClosedDoor(this);
        this.openDoorTimeout = openDoorTimeout;
        this.doorEngine = new DoorEngine(this, interval);
    }

    @Override
    public void open() {
        doorState.open();
    }

    @Override
    public void stop() {
        doorState.stop();
    }

    @Override
    public void close() {
        doorState.close();
    }

    @Override
    public void start() {
        doorState.start();
    }

    public void addOpeningPercentage(int number) {
        this.openingPercentage += number;
    }
}
