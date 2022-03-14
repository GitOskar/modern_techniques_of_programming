package pl.umcs;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;

@Slf4j
public class LetterCommand extends Command {

    private static final String STRING_TO_WRITE = "savetofile\n";

    public LetterCommand(LocalTime executeTime, String filePath) {
        super(executeTime, filePath);
    }

    @Override
    protected void methodToExecute() {
        try {
            Files.write(Paths.get(filePath), STRING_TO_WRITE.getBytes(),
                    StandardOpenOption.APPEND, StandardOpenOption.WRITE, StandardOpenOption.SYNC);
        } catch (IOException e) {
            log.error("Error during writing letter into file. Path: {} Error: {}", filePath, e.getMessage());
        }
    }
}
