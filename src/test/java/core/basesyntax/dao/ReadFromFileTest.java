package core.basesyntax.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileTest {
    private static final String FILE_DEST_WRONG = "src/test/resources/WrongPath.csv";
    private static final String FILE_DEST_TEST_1 = "src/test/resources/Test_1.csv";
    private static final String FILE_DEST_TEST_2 = "src/test/resources/Test_2.csv";
    private static final String FIRST_STRING = "banana";
    private static final String SECOND_STRING = "90";
    private static final List<String[]> list = new ArrayList<>();

    @Before
    public void setUp() {
        String[] testStringArray = {FIRST_STRING, SECOND_STRING};
        list.add(testStringArray);
    }

    @Test(expected = RuntimeException.class)
    public void fileReaderCreateExeption() {
        ReadFromFile newReader = new ReadFromFile();
        newReader.readFromFile(FILE_DEST_WRONG);
    }

    @Test
    public void fileExist() {
        ReadFromFile newReader = new ReadFromFile();
        newReader.readFromFile(FILE_DEST_TEST_1);
        Assert.assertTrue(Files.exists(Paths.get(FILE_DEST_TEST_1)));
    }

    @Test
    public void readFromFileOk() {
        ReadFromFile newReader = new ReadFromFile();
        List<String[]> testListReader = newReader.readFromFile(FILE_DEST_TEST_2);
        Assert.assertArrayEquals(list.get(0), testListReader.get(0));
    }
}