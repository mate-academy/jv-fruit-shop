package core.basesyntax.service.implementations;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterTest {
    public static final String REPORT = "Test text for filewriter";
    public static final String CORRECT_PATH = "src/test/resources/writer_test.csv";
    public static FileWriter fileWriter;

    @BeforeClass
    public static void initialize() {
        fileWriter = new CsvFileWriter();
    }

    @Test
    public void write_Correct() {
        fileWriter.write(REPORT, CORRECT_PATH);
        List<String> allLines;
        try {
            allLines = Files.readAllLines(Path.of(CORRECT_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Test for reader is failed in " + CORRECT_PATH);
        }
        Assert.assertEquals(REPORT, allLines.get(0));
    }

    @Test (expected = RuntimeException.class)
    public void nullPath_ThrowsException() {
        fileWriter.write("haha", "");
    }
}
