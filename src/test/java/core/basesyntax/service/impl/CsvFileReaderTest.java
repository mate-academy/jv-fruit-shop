package core.basesyntax.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileReaderTest {
    private static final CsvFileReader reader = new CsvFileReader();

    @Test
    public void read_ok() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("type,fruit,quantity");
        expectedList.add("b,banana,20");
        expectedList.add("b,apple,100");
        List<String> actualList = reader.readData("src/test/java/resources/fruit-test.csv");
        Assert.assertEquals(expectedList,actualList);
    }

    @Test(expected = RuntimeException.class)
    public void read_invalidPath() {
        reader.readData("src/test/java/resources/fruit.csv");
    }
}
