package core.basesyntax.read;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTest {
    private static final String FIRST_PATH = "src/test/resources/test_3.csv";
    private static final String SECOND_PATH = "src/test/resources/test_2.csv";
    private static final String EXPECTING_RESULT_SECOND = "s,banana,100,2020-10-17";
    private static final String EXPECTING_RESULT_THIRD = "fruit, quantity";
    private static final ReadFile READER = new ReadFile();

    @Test
    public void simpleReadFileTest() {
        List<String> expectResultFirst = new ArrayList<>();
        expectResultFirst.add(EXPECTING_RESULT_SECOND);
        List<String> actual = READER.readFile(FIRST_PATH);
        Assert.assertEquals(expectResultFirst, actual);
    }

    @Test
    public void shouldFileReaderTest() {
        String actual = READER.readFile(FIRST_PATH).get(0);
        Assert.assertEquals(EXPECTING_RESULT_SECOND, actual);
    }

    @Test(expected = RuntimeException.class)
    public void fileReaderTestFail() {
        READER.readFile("blblblb").get(0);
    }
}

