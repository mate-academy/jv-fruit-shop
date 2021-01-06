package core.basesyntax;

import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileWriterTest {
    private static final String INCORRECT_FILE_PATH = "";
    private static final String SOME_INFO = "Just for testing";
    private static final String CORRECT_FILE_PATH = "src/test/resources/FourthResult.csv";
    private static CsvFileWriter csvFileWriter;

    @Test(expected = RuntimeException.class)
    public void check_for_wrong_file_path() {
        csvFileWriter = new CsvFileWriterImpl(INCORRECT_FILE_PATH);
        csvFileWriter.writeToFile(SOME_INFO);
    }

    @Test
    public void check_for_correct_file_path() {
        String expected = readFile(CORRECT_FILE_PATH);
        csvFileWriter = new CsvFileWriterImpl(CORRECT_FILE_PATH);
        String actual = readFile(CORRECT_FILE_PATH);
        Assert.assertEquals(expected, actual);
    }

    private String readFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file", e);
        }
    }
}
