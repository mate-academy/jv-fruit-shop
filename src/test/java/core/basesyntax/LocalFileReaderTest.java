package core.basesyntax;

import org.junit.Test;
import org.junit.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LocalFileReaderTest {
    private static final String EMPTY_FILE = "test1.csv";
    private static final String EMPTY_FILE_NAME = "";
    private static final String NULL_FILE_NAME = null;
    private static final String JUST_HEADER_FILE = "test2.csv";
    private static final String WRONG_EXTENSION_FILE = "test3.txt";
    private static final String APPROPRIATE_DATA_FILE = "test6.csv";
    private static final String NON_EXISTENT_FILE_NAME = "test3.csv";

    private static final List<List<String>> EMPTY_LIST_RESULT = new ArrayList<>();
    private static final List<List<String>> ONLY_HEADER_RESULT = new ArrayList<>();
    private static final List<List<String>> PROPER_DATA_RESULT = new ArrayList<>();

    static {
        List<String> FIRST_LINE_FROM_FILE = new ArrayList<>(List.of("s", "banana", "100", "2020-10-17"));
        PROPER_DATA_RESULT.add(FIRST_LINE_FROM_FILE);
        List<String> SECOND_LINE_FROM_FILE = new ArrayList<>(List.of("r", "orange", "17", "2020-10-21"));
        PROPER_DATA_RESULT.add(SECOND_LINE_FROM_FILE);
        List<String> THIRD_LINE_FROM_FILE = new ArrayList<>(List.of("s", "apple", "29", "2020-10-22"));
        PROPER_DATA_RESULT.add(THIRD_LINE_FROM_FILE);
        List<String> FORTH_LINE_FROM_FILE = new ArrayList<>(List.of("b", "apple", "14", "2020-10-21"));
        PROPER_DATA_RESULT.add(FORTH_LINE_FROM_FILE);
    }

    @Test
    public void getOnlyHeaderFromFile() throws IOException {
        LocalFileReader reader = new LocalFileReader();
        List<List<String>> actualResult = reader.readFromFile(JUST_HEADER_FILE);
        Assert.assertEquals(ONLY_HEADER_RESULT, actualResult);
    }

    @Test
    public void readFromEmptyFile() throws IOException {
        LocalFileReader reader = new LocalFileReader();
        List<List<String>> actualResult = reader.readFromFile(EMPTY_FILE);
        Assert.assertEquals(EMPTY_LIST_RESULT, actualResult);
    }

    @Test
    public void readFilledWithDataFile() throws IOException {
        LocalFileReader reader = new LocalFileReader();
        List<List<String>> actualResult = reader.readFromFile(APPROPRIATE_DATA_FILE);
        Assert.assertEquals(PROPER_DATA_RESULT, actualResult);
    }

    @Test
    public void getExceptionWhenFileWrongExtension() throws IOException {
        LocalFileReader reader = new LocalFileReader();
        try {
            reader.readFromFile(EMPTY_FILE_NAME);
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenFileNameEmpty() throws IOException {
        LocalFileReader reader = new LocalFileReader();
        try {
            reader.readFromFile(WRONG_EXTENSION_FILE);
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionForNullFileName() throws IOException {
        LocalFileReader reader = new LocalFileReader();
        try {
            reader.readFromFile(NULL_FILE_NAME);
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenFileNotExist() throws IOException {
        LocalFileReader reader = new LocalFileReader();
        try {
            reader.readFromFile(NON_EXISTENT_FILE_NAME);
        } catch (FileNotFoundException message) {
            return;
        }
        Assert.fail("FileNotFoundException should be thrown");
    }
}
