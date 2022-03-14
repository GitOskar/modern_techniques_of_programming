package pl.umcs;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MainTest {

    private static final String FILE_PATH = "D:\\IdeaProjects\\command_design_pattern\\src\\test\\java\\pl\\umcs\\tmp.txt";

    @Test
    public void test() throws IOException {

        createTmpFile();

        List<Command> valueSource = asList(new LetterCommand(LocalTime.of(2, 15), FILE_PATH),
                new NumberCommand(LocalTime.of(3, 11), FILE_PATH),
                new SummarizeCommand(LocalTime.of(4, 15), FILE_PATH),
                new LetterCommand(LocalTime.of(10, 15), FILE_PATH),
                new NumberCommand(LocalTime.of(14, 11), FILE_PATH),
                new SummarizeCommand(LocalTime.of(19, 15), FILE_PATH));

        LocalDateTime from = LocalDateTime.of(1, 1, 1, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(1, 1, 2, 0, 0, 0);

        while (from.compareTo(to) <= 0) {
            LocalDateTime mockedNow = from;
            valueSource.forEach(command -> command.execute(mockedNow.toLocalTime()));

            from = from.plusMinutes(1);
        }

        String fileContent = new String(Files.readAllBytes(Paths.get(FILE_PATH)));

        deleteTmpFile();

        assertEquals(fileContent, getExpectedFileContent());
    }

    private void createTmpFile() throws IOException {
        File file = new File(FILE_PATH);
        file.createNewFile();
    }

    private void deleteTmpFile() {
        File file = new File(FILE_PATH);
        file.delete();
    }

    private String getExpectedFileContent() {
        return "savetofile\n" +
                "10000\n" +
                "sum:10000\n" +
                "savetofile\n" +
                "10000\n" +
                "sum:20000\n";
    }
}