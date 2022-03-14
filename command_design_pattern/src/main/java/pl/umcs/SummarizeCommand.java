package pl.umcs;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

@Slf4j
public class SummarizeCommand extends Command {

    public SummarizeCommand(LocalTime executeTime, String filePath) {
        super(executeTime, filePath);
    }

    @Override
    protected void methodToExecute() {

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            Integer sum = lines.mapToInt(this::tryToExtractValue)
                               .sum();

            Files.write(Paths.get(filePath), toFileRow(sum).getBytes(),
                    StandardOpenOption.APPEND, StandardOpenOption.WRITE, StandardOpenOption.SYNC);
        } catch (IOException e) {
            log.error("Error during executing summarize command. Path: {} Error: {}", filePath, e.getMessage());
        }
    }

    private int tryToExtractValue(String line) {
        try {
            return parseInt(line.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private String toFileRow(Integer sum) {
        return "sum:" + sum.toString() + "\n";
    }
}
