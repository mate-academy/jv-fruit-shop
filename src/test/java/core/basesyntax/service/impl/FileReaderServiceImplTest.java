package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.FileReaderService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class FileReaderServiceImplTest {
    private static FileReaderService reader;

    @BeforeClass
    public static void setup() {
        reader = new FileReaderServiceImpl();
    }

    @Test
    public void normalDataTest() {
        List<FruitDto> expected = List.of(
                new FruitDto("s", "banana", 100, LocalDate.parse("2020-08-26")),
                new FruitDto("s", "banana", 100, LocalDate.parse("2020-08-26")),
                new FruitDto("b", "banana", 50, LocalDate.parse("2020-08-26")),
                new FruitDto("r", "banana", 50, LocalDate.parse("2020-07-26")),
                new FruitDto("s", "orange", 100, LocalDate.parse("2020-08-26")),
                new FruitDto("s", "kiwi", 100, LocalDate.parse("2020-06-26")));
        List<FruitDto> actual = reader.read("src/test/resources/normalData.csv");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void noSuchFileTest() {
        reader.read("src/test/resources/nofile.csv");
    }

    @Test(expected = RuntimeException.class)
    public void emptyFileTest() {
        reader.read("src/test/resources/empty.csv");
    }
}
