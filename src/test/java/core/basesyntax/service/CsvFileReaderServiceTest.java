package core.basesyntax.service;

import org.junit.Test;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceTest {
    private static final String VALID_PATH = "src/main/resources/test_fruit_transactions.csv";
    private static final String INVALID_PATH = "src/main/resources/invalid_path.csv";
    private static final String EMPTY_FILE = "src/main/resources/empty_file.csv";
    private static final List<String[]> EMPTY_LIST = new ArrayList<>();

    @Test
    public void getTransactions_validPath() {
        FileReaderService reader = new CsvFileReaderService();
        List<String[]> actualResult = reader.getTransactions(VALID_PATH);
        String[] expectedFirstLine = new String[]{"s", "banana", "100", "2020-11-01"};
        String[] expectedSecondLine = new String[]{"b", "banana", "15", "2020-10-10"};
        String[] expectedThirdLine = new String[]{"r", "banana", "2", "2020-11-01"};
        int expectedSize = 3;
        Assert.assertEquals("The actual size of the list does not match the expected size.",
                expectedSize, actualResult.size());
        Assert.assertArrayEquals(expectedFirstLine, actualResult.get(0));
        Assert.assertArrayEquals(expectedSecondLine, actualResult.get(1));
        Assert.assertArrayEquals(expectedThirdLine, actualResult.get(2));
    }

    @Test(expected = RuntimeException.class)
    public void getTransactions_invalidPath() {
        FileReaderService reader = new CsvFileReaderService();
        reader.getTransactions(INVALID_PATH);
    }

    @Test
    public void getTransactions_emptyFile() {
        FileReaderService reader = new CsvFileReaderService();
        List<String[]> actualResult = reader.getTransactions(EMPTY_FILE);
        Assert.assertEquals("Test failed! An empty list was expected.", EMPTY_LIST, actualResult);
    }
}