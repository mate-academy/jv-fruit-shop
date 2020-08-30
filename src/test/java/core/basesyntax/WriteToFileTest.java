package core.basesyntax;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.util.IllegalFormatFlagsException;
import java.util.List;
import java.util.stream.Collectors;

public class WriteToFileTest {
    private static StorageUpdater newUpdate;
    private static final String FILLED_FILE_NAME = "src/test/resources/test11.csv";
    private static final String SECOND_FILLED_FILE_NAME = "src/test/resources/test6.csv";
    private static final String OUTPUT_FILE_PATH = "src/test/resources/current_reminder.csv";
    private static final String NOT_EMPTY_STORAGE_OUTPUT_FILE_PATH = "src/test/resources/current_reminder2.csv";
    private static final String WRONG_HEADER_FILE = "src/test/resources/test4.csv";
    private static final String RESULT_ON_EMPTY_STORAGE = "src/test/resources/result1.csv";
    private static final String RESULT_ON_NOT_EMPTY_STORAGE = "src/test/resources/result2.csv";

    @Before
    public void setUpStorage() {
        newUpdate = new StorageUpdaterImpl();
        Storage.clearStorage();
    }

    @Test
    public void checkFileCreation() throws IOException {
        LocalFileReader reader = new LocalFileReader(FILLED_FILE_NAME);
        newUpdate.parseDataToStorage(reader.readTransactionsFile());
        CsvFileWriter parser = new CsvFileWriter(OUTPUT_FILE_PATH);
        parser.writeToFile();
        Assert.assertTrue(new File(OUTPUT_FILE_PATH).isFile());
    }

    @Test
    public void checkResultOnEmptyStorage() throws IOException {
        LocalFileReader reader = new LocalFileReader(FILLED_FILE_NAME);
        newUpdate.parseDataToStorage(reader.readTransactionsFile());
        CsvFileWriter parser = new CsvFileWriter(OUTPUT_FILE_PATH);
        parser.writeToFile();
        List<String> expectedResult = Files.lines(Paths.get(RESULT_ON_EMPTY_STORAGE)).collect(Collectors.toList());
        List<String> actualResult = Files.lines(Paths.get(OUTPUT_FILE_PATH)).collect(Collectors.toList());
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateNotEmptyStorageFromFile() throws IOException {
        LocalFileReader reader = new LocalFileReader(FILLED_FILE_NAME);
        newUpdate.parseDataToStorage(reader.readTransactionsFile());
        CsvFileWriter writer = new CsvFileWriter(OUTPUT_FILE_PATH);
        writer.writeToFile();

        LocalFileReader secondFileReader = new LocalFileReader(SECOND_FILLED_FILE_NAME);
        newUpdate.parseDataToStorage(secondFileReader.readTransactionsFile());
        CsvFileWriter secondFileWriter = new CsvFileWriter(NOT_EMPTY_STORAGE_OUTPUT_FILE_PATH);
        secondFileWriter.writeToFile();

        List<String> expectedResult = Files.lines(Paths.get(RESULT_ON_NOT_EMPTY_STORAGE)).collect(Collectors.toList());
        List<String> actualResult = Files.lines(Paths.get(NOT_EMPTY_STORAGE_OUTPUT_FILE_PATH)).collect(Collectors.toList());
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getExceptionWhenWrongHeader() throws IOException {
        LocalFileReader reader = new LocalFileReader(WRONG_HEADER_FILE);
        try {
            newUpdate.parseDataToStorage(reader.readTransactionsFile());
            CsvFileWriter parser = new CsvFileWriter(OUTPUT_FILE_PATH);
            parser.writeToFile();
        } catch (IllegalFormatFlagsException message) {
            return;
        }
        Assert.fail("IllegalFormatFlagsException should be thrown");
    }
}
