package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImplTest {
    private final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final String FILE_PATH_TO_EMPTY_FILE
            = "src/test/resources/empty";
    private static final String FILE_PATH_TO_FILE_DOES_NOT_EXIST
            = "src/test/resources/k.csv";
    private static final String FILE_PATH_TO_FILE_WITH_ONE_LINE_INFORMATION
            = "src/test/resources/testOneOperation";
    private static final String FILE_PATH_TO_OK_FILE
            = "src/test/resources/basic";
    private static final String FILE_PATH_TO_FILE_WITH_NOT_ENOUGH_INFORMATION
            = "src/test/resources/notEnoughData";
    private static final String FILE_PATH_TO_FILE_WITH_WRONG_OPERATION
            = "src/test/resources/wrongOperation";

    @Test(expected = RuntimeException.class)
    public void readFileEmpty() {
        fileReaderService
                .readFile(FILE_PATH_TO_EMPTY_FILE, ",");
    }

    @Test(expected = RuntimeException.class)
    public void readFileDoesNotExist() {
        fileReaderService
                .readFile(FILE_PATH_TO_FILE_DOES_NOT_EXIST, ",");
    }

    @Test(expected = RuntimeException.class)
    public void readFileWithWrongSeparator() {
        fileReaderService.readFile(FILE_PATH_TO_FILE_WITH_ONE_LINE_INFORMATION, ":");
    }

    @Test(expected = RuntimeException.class)
    public void readFileWithNotEnoughInformation() {
        fileReaderService.readFile(FILE_PATH_TO_FILE_WITH_NOT_ENOUGH_INFORMATION, ",");
    }

    @Test(expected = RuntimeException.class)
    public void readFileWithWrongOperation() {
        fileReaderService.readFile(FILE_PATH_TO_FILE_WITH_WRONG_OPERATION, ",");
    }

    @Test()
    public void readFileWithOneLineOk() {
        List<List<String>> expectedResultOfReading = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("s");
        row1.add("banana");
        row1.add("100");
        row1.add("2020-10-17");
        expectedResultOfReading.add(row1);

        List<List<String>> actual = fileReaderService
                .readFile(FILE_PATH_TO_FILE_WITH_ONE_LINE_INFORMATION, ",");
        Assert.assertEquals(expectedResultOfReading, actual);
    }

    @Test()
    public void readFileWithMoreThanOneOk() {
        List<List<String>> expectedResultOfReading = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("s");
        row1.add("banana");
        row1.add("100");
        row1.add("2020-10-17");
        List<String> row2 = new ArrayList<>();
        row2.add("s");
        row2.add("banana");
        row2.add("100");
        row2.add("2020-10-27");
        List<String> row3 = new ArrayList<>();
        row3.add("b");
        row3.add("banana");
        row3.add("70");
        row3.add("2020-10-20");
        expectedResultOfReading.add(row1);
        expectedResultOfReading.add(row2);
        expectedResultOfReading.add(row3);

        List<List<String>> actual = fileReaderService
                .readFile(FILE_PATH_TO_OK_FILE, ",");
        Assert.assertEquals(expectedResultOfReading, actual);
    }
}
