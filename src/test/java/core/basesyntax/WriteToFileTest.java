package core.basesyntax;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;

public class WriteToFileTest {
    private static final String FILLED_FILE_NAME = "test11.csv";
    private static final String SAVE_TO_FILE_NAME = "current_reminder.csv";
    private static final String WRONG_HEADER_FILE = "test4.csv";
    private static final String RESULT_ON_EMPTY_STORAGE = "result1.csv";
    private static final String RESULT_ON_NOT_EMPTY_STORAGE = "result2.csv";
    private static WriteToFile parser = new WriteToFile();

    @Before
    public void setUpStorage() {
        Storage.fruitsInStore = new HashMap<>();
    }

    @Test
    public void checkFileCreation() throws IOException {
        parser.csvFileWriter(SAVE_TO_FILE_NAME, FILLED_FILE_NAME);
        Assert.assertTrue(new File(SAVE_TO_FILE_NAME).isFile());
    }

    @Test
    public void checkResultOnEmptyStorage() throws IOException {
        parser.csvFileWriter(SAVE_TO_FILE_NAME, FILLED_FILE_NAME);
        byte[] expectedResult = Files.readAllBytes(Paths.get(RESULT_ON_EMPTY_STORAGE));
        byte[] actualResult = Files.readAllBytes(Paths.get(SAVE_TO_FILE_NAME));
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void updateNotEmptyStorageFromFile() throws IOException {
        parser.csvFileWriter(SAVE_TO_FILE_NAME, FILLED_FILE_NAME);
        parser.csvFileWriter(SAVE_TO_FILE_NAME, FILLED_FILE_NAME);
        byte[] expectedResult = Files.readAllBytes(Paths.get(RESULT_ON_NOT_EMPTY_STORAGE));
        byte[] actualResult = Files.readAllBytes(Paths.get(SAVE_TO_FILE_NAME));
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void getExceptionWhenWrongHeader() throws IOException {
        try {
            parser.csvFileWriter(SAVE_TO_FILE_NAME, WRONG_HEADER_FILE);
        } catch (IllegalFormatFlagsException message) {
            return;
        }
        Assert.fail("IllegalFormatFlagsException should be thrown");
    }
}
