package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyFileReaderCsvImplTest {
    public static final String TEST_FRUIT_EMPTY_CSV = "src/test/resources/test-fruit-empty.csv";
    private static final String TEST_INPUT_FRUIT_CSV = "src/test/resources/test-input-fruit.csv";
    private static final String TEST_INPUT_FRUIT2_CSV = "src/test/resources/test-input-fruit2.csv";
    private static final String TEST_FRUIT_WHICH_LOCK_CSV
            = "src/test/resources/test-file-which-lock.csv";
    private static MyFileReader myFileReaderCsv;

    @BeforeClass
    public static void beforeClass() {
        myFileReaderCsv = new MyFileReaderCsvImpl();
    }

    @Test
    public void readFromFile_Ok() {
        List<String> expected = Arrays.asList("type,fruit,quantity","b,banana,20","b,apple,100");
        List<String> actual = myFileReaderCsv.readFromFile(TEST_INPUT_FRUIT_CSV);
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = RuntimeException.class)
    public void readFromDoNotExistFile_NotOk() {
        myFileReaderCsv.readFromFile("src/test/");
    }

    @Test
    public void readFromEmptyFile_Ok() {
        List<String> expected = new ArrayList<>();
        List<String> actual = myFileReaderCsv.readFromFile(TEST_FRUIT_EMPTY_CSV);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void readFromTwoDifferentFile_NotOk() {
        List<String> expected = myFileReaderCsv.readFromFile(TEST_FRUIT_EMPTY_CSV);
        List<String> actual = myFileReaderCsv.readFromFile(TEST_INPUT_FRUIT_CSV);
        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void readFromTwoSameFile_Ok() {
        List<String> expected = myFileReaderCsv.readFromFile(TEST_INPUT_FRUIT_CSV);
        List<String> actual = myFileReaderCsv.readFromFile(TEST_INPUT_FRUIT2_CSV);
        Assert.assertEquals(expected,actual);
    }
}
