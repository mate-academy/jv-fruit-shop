package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.service.CsvFileReader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderTest {
    private static CsvFileReader reader;

    @BeforeClass
    public static void BeforeClass() {
        reader = new CsvFileReader();
    }

    @Test
    public void normalInputTest() {
        List<FruitDto> expected = new ArrayList<>();
        expected.add(new FruitDto("s", "banana", 100, LocalDate.parse("2020-10-17")));
        expected.add(new FruitDto("b", "banana", 13, LocalDate.parse("2020-10-15")));
        expected.add(new FruitDto("r", "banana", 10, LocalDate.parse("2020-10-17")));
        expected.add(new FruitDto("s", "apple", 300, LocalDate.parse("2020-10-18")));

        List<FruitDto> actual = CsvFileReader.readFile("src/main/resources/NormalInput.csv");

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void fileDoesNotExistTest() {
        CsvFileReader.readFile("notExistingFile.csv");
    }


}
