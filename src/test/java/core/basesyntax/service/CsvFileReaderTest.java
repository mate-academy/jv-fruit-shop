package core.basesyntax.service;

import core.basesyntax.service.impl.CsvFilereaderImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileReaderTest {
    private static final String PATH_TO_THREE_LINE_FILE = "src/test/resources/test2_3lines";
    private static final String PATH_TO_ONE_LINE_FILE = "src/test/resources/test_read_1_line";
    private static List<String> data;
    private static CsvFileReader fileReader = new CsvFilereaderImpl();

    @After
    public void cleanData() {
        if (data != null) {
            data.clear();
        }
    }

    @Test
    public void checkOneLine_Ok() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,150");
        data = fileReader.readFile(PATH_TO_ONE_LINE_FILE);
        Assert.assertEquals(expected.size(), data.size());
        Assert.assertEquals(expected, data);
    }

    @Test
    public void checkOThreeLine_Ok() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,60");
        data = fileReader.readFile(PATH_TO_THREE_LINE_FILE);
        Assert.assertEquals(expected.size(), data.size());
        Assert.assertEquals(expected, data);
    }

    @Test(expected = RuntimeException.class)
    public void fileNotFound() {
        data = fileReader.readFile("/opps/no_file_here.");
    }
}
