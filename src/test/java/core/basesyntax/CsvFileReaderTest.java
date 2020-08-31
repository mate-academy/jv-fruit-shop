package core.basesyntax;

import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.FruitDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderTest {
    private static final String INPUT_FILE = "src\\test\\resources\\data.csv";
    private static final String EMPTY_FILE = "src\\test\\resources\\empty.csv";
    private static final String NOT_EXIST_FILE = "src\\test\\resources\\data23.csv";
    private static List<FruitDto> expected;

    @Before
    public void beforeExpected() {
        expected = new ArrayList<>();
    }

    @Test
    public void readEmptyFile() {
        List<FruitDto> current = CsvFileReader.readFromFile(EMPTY_FILE);
        Assert.assertArrayEquals(expected.toArray(), current.toArray());
    }

    @Test
    public void readValidFile() {
        List<FruitDto> current = CsvFileReader.readFromFile(INPUT_FILE);
        Assert.assertEquals("s", current.get(0).getType());
        Assert.assertEquals(330, current.get(1).getQuantity());
        Assert.assertEquals("melon", current.get(2).getFruit());
        Assert.assertEquals("2020-08-30", current.get(3).getDate());
    }

    @Test(expected = RuntimeException.class)
    public void readNotExistFile() {
        List<FruitDto> current = CsvFileReader.readFromFile(NOT_EXIST_FILE);
    }
}
