package core.basesyntax;

import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileReaderTest {
    private static final String INCORRECT_FILE_PATH = "QWERTY.CSV";
    private static final String CORRECT_FILE_PATH = "src/test/resources/FirstTest.csv";
    private static CsvFileReader csvFileReader;

    @Test(expected = RuntimeException.class)
    public void check_for_incorrect_filePath() {
        csvFileReader = new CsvFileReaderImpl(INCORRECT_FILE_PATH);
        csvFileReader.readFromFile();
    }

    @Test
    public void check_for_correct_filePath() {
        csvFileReader = new CsvFileReaderImpl(CORRECT_FILE_PATH);
        List<String> expected = Arrays.asList(csvFileReader.getDataFromFile(CORRECT_FILE_PATH));
        CsvFileReader fileReader = new CsvFileReaderImpl(CORRECT_FILE_PATH);
        List<String> actual = Arrays.asList(fileReader.getDataFromFile(CORRECT_FILE_PATH));
        Assert.assertEquals(expected, actual);
    }
}
