package simulator.state;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import simulator.DoorSimulator;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class OpenedDoor extends BaseDoorState implements Runnable {

    private Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(false);

    public OpenedDoor(DoorSimulator doorSimulator) {
        super(doorSimulator);
    }

    @Override
    public void open() {
        // nothing to do
    }

    @Override
    public void stop() {
        // nothing to do
    }

    @Override
    public void close() {
        this.running.set(false);
        this.doorSimulator.getDoorEngine()
                .startClosing();
        doorSimulator.setDoorState(new ClosingDoor(doorSimulator));
    }

    @Override
    public void start() {
        this.running.set(true);
        this.worker = new Thread(this);
        this.worker.start();

    }

    @Override
    @SneakyThrows
    public void run() {
        long now;
        long timeoutBorder = Instant.now()
                .getEpochSecond() + this.doorSimulator.getOpenDoorTimeout();

        do {
            now = Instant.now()
                    .getEpochSecond();

            Thread.sleep(100);
        } while (now < timeoutBorder && running.get());
        log.info("Opened door timeout, doors are closing");
        close();
    }
}
