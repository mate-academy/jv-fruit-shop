package core.basesyntax;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.iooperations.Reader;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
        private Reader reader= new Reader();

    @Test
    public void normalDataTest() {
        List<FruitDto> expected = new ArrayList<>();
        expected.add(new FruitDto("s", "banana", "185", "2020-11-20"));
        expected.add(new FruitDto("b", "banana", "20", "2020-10-19"));
        expected.add(new FruitDto("r", "banana", "5", "2020-11-20"));
        expected.add(new FruitDto("s", "apple", "50", "2020-11-17"));
        expected.add(new FruitDto("b", "apple", "20", "2020-10-19"));
        expected.add(new FruitDto("r", "banana", "5", "2020-11-20"));
        expected.add(new FruitDto("s", "orange", "30", "2020-11-17"));
        expected.add(new FruitDto("b", "orange", "10", "2020-10-19"));
        expected.add(new FruitDto("r", "orange", "1", "2020-11-20"));
        List<FruitDto> actual = reader.readFromFile("src/CsvFolder/inputNormal1.csv");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void noSuchFileTest() {
        reader.readFromFile("src/CsvFolder/wrongName.csv");
    }

    @Test(expected = RuntimeException.class)
    public void emptyFileTest() {
        reader.readFromFile("src/main/resources/emptyFile.csv");
    }
}