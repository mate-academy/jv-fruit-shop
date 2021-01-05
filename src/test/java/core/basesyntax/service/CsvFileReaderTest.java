package core.basesyntax.service;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileReaderTest {
    private static FilesReader filesReader;
    private static final String file = "src/test/resources/storage.csv";

    @BeforeClass
    public static void initialization() {
        filesReader = new CsvFileReader();
    }

    @Test
    public void read_correctData_Ok() {
        List<String[]> data = filesReader.read(file);
        Assert.assertEquals(3, data.size());
        Assert.assertTrue(Arrays.equals(data.get(0), new String[]{"b", "banana", "20"}));
        Assert.assertTrue(Arrays.equals(data.get(1), new String[]{"b", "apple", "100"}));
        Assert.assertTrue(Arrays.equals(data.get(2), new String[]{"s", "banana", "100"}));
    }

    @Test(expected = RuntimeException.class)
    public void read_incorrectPath_Ok() {
        List<String[]> data = filesReader.read("");
    }
}
