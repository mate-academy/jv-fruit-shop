package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.DataReader;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvDataReaderImplTest {
    private static DataReader csvReader;
    private static List<String> expectedStringList;

    @BeforeClass
    public static void beforeAll() {
        csvReader = new CsvDataReaderImpl();
    }

    @Test
    public void readData_Ok() {
        String correctFilePath = "src/test/resources/test-fruit.csv";
        expectedStringList = List.of("type,fruit,quantity", "b,banana,20", "s,apple,100");
        assertEquals(expectedStringList, csvReader.read(correctFilePath));
    }

    @Test(expected = RuntimeException.class)
    public void readData_NotOk() {
        String incorrectFilePath = "src/test/test-fruit.csv";
        csvReader.read(incorrectFilePath);
    }
}
