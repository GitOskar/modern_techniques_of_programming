package simulator.engine;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import simulator.DoorSimulator;
import simulator.state.ClosedDoor;
import simulator.state.OpenedDoor;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@RequiredArgsConstructor
public class DoorEngine implements Runnable {

    private Thread worker;
    private RunningMode runningMode;
    private AtomicBoolean running = new AtomicBoolean(false);

    private final DoorSimulator doorSimulator;
    private final int interval;

    public void startOpening() {
        runningMode = RunningMode.OPEN;
        start();
    }

    public void startClosing() {
        runningMode = RunningMode.CLOSE;
        start();
    }

    private void start() {
        running.set(true);
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {

        switch (runningMode) {
            case OPEN -> open();
            case CLOSE -> close();
            default -> {
                log.error("Unsupported simulator.engine operation");
                throw new UnsupportedOperationException("Engine operation not supported");
            }
        }
    }

    @SneakyThrows
    private void close() {
        while (doorSimulator.getOpeningPercentage() > 0 && running.get()) {

            Thread.sleep(interval);
            doorSimulator.addOpeningPercentage(-1);

            if (doorSimulator.getOpeningPercentage() % 10 == 0) {
                log.info("Door opening percentage: {}%", doorSimulator.getOpeningPercentage());
            }
        }

        if (running.get()) {
            log.info("Door closed");
            doorSimulator.setDoorState(new ClosedDoor(doorSimulator));
        }
    }

    @SneakyThrows
    private void open() {
        while (doorSimulator.getOpeningPercentage() < 100 && running.get()) {

            Thread.sleep(interval);
            doorSimulator.addOpeningPercentage(1);

            if (doorSimulator.getOpeningPercentage() % 10 == 0) {
                log.info("Door opening percentage: {}%", doorSimulator.getOpeningPercentage());
            }
        }

        if (running.get()) {
            log.info("Doors opened");
            doorSimulator.setDoorState(new OpenedDoor(doorSimulator));
            doorSimulator.start();
        }
    }
}
