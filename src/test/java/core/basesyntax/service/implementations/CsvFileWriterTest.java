package core.basesyntax.service.implementations;

import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterTest {
    public static final String REPORT = "Test text for filewriter";
    public static final String CORRECT_PATH = "src/main/resources/writer_test.csv";
    public static FileWriter fileWriter;
    public static FileReader fileReader;

    @BeforeClass
    public static void initialize() {
        fileWriter = new CsvFileWriter();
        fileReader = new CsvFileReader();
    }

    @Test
    public void write_Correct() {
        fileWriter.write(REPORT, CORRECT_PATH);
        List<String> allLines = fileReader.getAllLines(CORRECT_PATH);
        Assert.assertEquals(REPORT, allLines.get(0));
    }

    @Test (expected = RuntimeException.class)
    public void nullPath_ThrowsException() {
        fileWriter.write("haha", "");
    }
}
