package core.basesyntax;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;

public class WriteToFileTest {
    private static StorageUpdater newUpdate;
    private static final String FILLED_FILE_NAME = "src\\test\\resources\\test11.csv";
    private static final String SECOND_FILLED_FILE_NAME = "src\\test\\resources\\test6.csv";
    private static final String OUTPUT_FILE_PATH = "src\\test\\resources\\current_reminder.csv";
    private static final String NOT_EMPTY_STORAGE_OUTPUT_FILE_PATH = "src\\test\\resources\\current_reminder2.csv";
    private static final String WRONG_HEADER_FILE = "src\\test\\resources\\test4.csv";
    private static final String RESULT_ON_EMPTY_STORAGE = "src\\test\\resources\\result1.csv";
    private static final String RESULT_ON_NOT_EMPTY_STORAGE = "src\\test\\resources\\result2.csv";

    @Before
    public void setUpStorage() {
        newUpdate = new StorageUpdaterImpl();
        Storage.clearStorage();
    }

    @Test
    public void checkFileCreation() throws IOException {
        LocalFileReader reader = new LocalFileReader(FILLED_FILE_NAME);
        newUpdate.parseData(reader.readFromFile());
        WriteToFile parser = new WriteToFile(OUTPUT_FILE_PATH);
        parser.csvFileWriter();
        Assert.assertTrue(new File(OUTPUT_FILE_PATH).isFile());
    }

    @Test
    public void checkResultOnEmptyStorage() throws IOException {
        LocalFileReader reader = new LocalFileReader(FILLED_FILE_NAME);
        newUpdate.parseData(reader.readFromFile());
        WriteToFile parser = new WriteToFile(OUTPUT_FILE_PATH);
        parser.csvFileWriter();
        byte[] expectedResult = Files.readAllBytes(Paths.get(RESULT_ON_EMPTY_STORAGE));
        byte[] actualResult = Files.readAllBytes(Paths.get(OUTPUT_FILE_PATH));
        System.out.println(Files.readAllLines(Path.of(OUTPUT_FILE_PATH)).toString());
        System.out.println(Files.readAllLines(Path.of(RESULT_ON_EMPTY_STORAGE)).toString());
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void updateNotEmptyStorageFromFile() throws IOException {
        LocalFileReader reader = new LocalFileReader(FILLED_FILE_NAME);
        newUpdate.parseData(reader.readFromFile());
        WriteToFile writer = new WriteToFile(OUTPUT_FILE_PATH);
        writer.csvFileWriter();

        LocalFileReader secondFileReader = new LocalFileReader(SECOND_FILLED_FILE_NAME);
        newUpdate.parseData(secondFileReader.readFromFile());
        WriteToFile secondFileWriter = new WriteToFile(NOT_EMPTY_STORAGE_OUTPUT_FILE_PATH);
        secondFileWriter.csvFileWriter();

        byte[] expectedResult = Files.readAllBytes(Paths.get(RESULT_ON_NOT_EMPTY_STORAGE));
        byte[] actualResult = Files.readAllBytes(Paths.get(NOT_EMPTY_STORAGE_OUTPUT_FILE_PATH));
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void getExceptionWhenWrongHeader() throws IOException {
        LocalFileReader reader = new LocalFileReader(WRONG_HEADER_FILE);
        try {
            newUpdate.parseData(reader.readFromFile());
            WriteToFile parser = new WriteToFile(OUTPUT_FILE_PATH);
            parser.csvFileWriter();
        } catch (IllegalFormatFlagsException message) {
            return;
        }
        Assert.fail("IllegalFormatFlagsException should be thrown");
    }
}
