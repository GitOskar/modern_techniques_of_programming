package pl.umcs;

import lombok.RequiredArgsConstructor;

import java.time.LocalTime;

@RequiredArgsConstructor
public abstract class Command {

    private final LocalTime executeTime;
    protected final String filePath;

    public final void execute(LocalTime now) {
        if (canExecute(now)) {
            methodToExecute();
        }
    }

    protected abstract void methodToExecute();

    protected final boolean canExecute(LocalTime now) {

        return executeTime.getHour() == now.getHour() && executeTime.getMinute() == now.getMinute();
    }
}