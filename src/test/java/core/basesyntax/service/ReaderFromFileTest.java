package core.basesyntax.service;

import core.basesyntax.exceptions.WrongFormatException;
import core.basesyntax.exceptions.EmptyFileException;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class ReaderFromFileTest {

    public final static String FIRST_PATH = "src/test/java/resourses/test1.csv";
    public final static String SECOND_PATH = "src/test/java/resourses/test2.csv";
    public final static String THIRD_PATH = "src/test/java/resourses/WrongFormatTest.csv";
    public final static String FOURTH_PATH = "src/test/java/resourses/emptyFile.csv";
    ReaderFromFile reader = new ReaderFromFile();


    @Test
    public void simpleReadFileTest() {
        String[] EXPECTING_RESULT_FIRST = {"s", "banana", "100", "2020-10-17"};
        List<List<String>> actual = reader.readFile(FIRST_PATH);
        Assert.assertEquals(Arrays.asList(EXPECTING_RESULT_FIRST), actual.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void fileReaderTestFail() {
        reader.readFile("skorunkaZMaslom");
    }

    @Test
    public void fileReaderTestWithMultipleLines() {
        int actual = reader.readFile(SECOND_PATH).size();
        Assert.assertEquals(4, actual);
    }

    @Test(expected = EmptyFileException.class)
    public void EmptyFileTest() {
        int actual = reader.readFile(FOURTH_PATH).get(0).size();
    }

    @Test(expected = WrongFormatException.class)
    public void WrongFileFormatTest() {
        int actual = reader.readFile(THIRD_PATH).get(0).size();
    }
}
