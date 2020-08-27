package core.basesyntax;

import org.junit.Test;
import org.junit.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LocalFileReaderTest {
    private static final String EMPTY_FILE_NAME = "";
    private static final String NULL_FILE_NAME = null;
    private static final String EMPTY_FILE = "src/test/resources/test1.csv";
    private static final String NO_HEADER_FILE = "src/test/resources/test4.csv";
    private static final String WRONG_DATE_FILE = "src/test/resources/test9.csv";
    private static final String JUST_HEADER_FILE = "src/test/resources/test2.csv";
    private static final String WRONG_QUANTITY_FILE = "src/test/resources/test8.csv";
    private static final String INCOMPLETE_DATA_FILE = "src/test/resources/test10.csv";
    private static final String WRONG_EXTENSION_FILE = "src/test/resources/test3.txt";
    private static final String APPROPRIATE_DATA_FILE = "src/test/resources/test6.csv";
    private static final String NON_EXISTENT_FILE_NAME = "src/test/resources/test3.csv";
    private static final String WRONG_OPERATION_TYPE_FILE = "src/test/resources/test7.csv";

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
        LocalFileReader reader = new LocalFileReader(JUST_HEADER_FILE);
        List<List<String>> actualResult = reader.readFromFile();
        Assert.assertEquals(ONLY_HEADER_RESULT, actualResult);
    }

    @Test
    public void readFromEmptyFile() throws IOException {
        LocalFileReader reader = new LocalFileReader(EMPTY_FILE);
        List<List<String>> actualResult = reader.readFromFile();
        Assert.assertEquals(EMPTY_LIST_RESULT, actualResult);
    }

    @Test
    public void readProperDataFile() throws IOException {
        LocalFileReader reader = new LocalFileReader(APPROPRIATE_DATA_FILE);
        List<List<String>> actualResult = reader.readFromFile();
        Assert.assertEquals(PROPER_DATA_RESULT, actualResult);
    }

    @Test
    public void getExceptionWhenFileWrongExtension() throws IOException {
        LocalFileReader reader = new LocalFileReader(EMPTY_FILE_NAME);
        try {
            reader.readFromFile();
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenFileNameEmpty() throws IOException {
        LocalFileReader reader = new LocalFileReader(WRONG_EXTENSION_FILE);
        try {
            reader.readFromFile();
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionForNullFileName() throws IOException {
        LocalFileReader reader = new LocalFileReader(NULL_FILE_NAME);
        try {
            reader.readFromFile();
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenFileNotExist() throws IOException {
        LocalFileReader reader = new LocalFileReader(NON_EXISTENT_FILE_NAME);
        try {
            reader.readFromFile();
        } catch (FileNotFoundException message) {
            return;
        }
        Assert.fail("FileNotFoundException should be thrown");
    }

    @Test
    public void getExceptionWhenWrongHeader() throws IOException {
        LocalFileReader reader = new LocalFileReader(NO_HEADER_FILE);
        try {
            reader.readFromFile();
        } catch (IllegalFormatFlagsException message) {
            return;
        }
        Assert.fail("IllegalFormatFlagsException should be thrown");
    }

    @Test
    public void getExceptionWhenOperationIncompatible() throws IOException {
        LocalFileReader reader = new LocalFileReader(WRONG_OPERATION_TYPE_FILE);
        try {
            reader.readFromFile();
        } catch (IllegalFormatException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenQuantityIncompatible() throws IOException {
        LocalFileReader reader = new LocalFileReader(WRONG_QUANTITY_FILE);
        try {
            reader.readFromFile();
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenDateIncompatible() throws IOException {
        LocalFileReader reader = new LocalFileReader(WRONG_DATE_FILE);
        try {
            reader.readFromFile();
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenDataIncomplete() throws IOException {
        LocalFileReader reader = new LocalFileReader(INCOMPLETE_DATA_FILE);
        try {
            reader.readFromFile();
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }
}
