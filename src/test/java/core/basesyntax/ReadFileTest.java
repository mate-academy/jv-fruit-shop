package core.basesyntax;

import core.basesyntax.servise.FileReadService;
import core.basesyntax.servise.ReadFile;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTest {
    private static final String FILE_WITH_CORRECTLY_DATA = "src/test/resources/FruitTestOk.csv";
    private static final String EMPTY_DATA = "src/test/resources/DataIsEmpty.csv";
    private static final String WRONG_NAME_FILE = "wrongNameFile.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static FileReadService readService;

    @BeforeClass
    public static void BeforeClass() {
        readService = new ReadFile();
    }

    @Test
    public void fileReadOk() {
        List<ProductsDto> expected = new ArrayList<>();
        expected.add(new ProductsDto("s", "banana", 68, LocalDate.parse("2020-11-20", DATE_TIME_FORMATTER)));
        expected.add(new ProductsDto("b", "banana", 20, LocalDate.parse("2020-10-19", DATE_TIME_FORMATTER)));
        expected.add(new ProductsDto("r", "banana", 5, LocalDate.parse("2020-11-20", DATE_TIME_FORMATTER)));
        expected.add(new ProductsDto("s", "apple", 50, LocalDate.parse("2020-11-17", DATE_TIME_FORMATTER)));
        expected.add(new ProductsDto("b", "apple", 20, LocalDate.parse("2020-10-19", DATE_TIME_FORMATTER)));
        expected.add(new ProductsDto("r", "apple", 5, LocalDate.parse("2020-11-20", DATE_TIME_FORMATTER)));
        expected.add(new ProductsDto("s", "orange", 20, LocalDate.parse("2020-11-17", DATE_TIME_FORMATTER)));
        expected.add(new ProductsDto("b", "orange", 10, LocalDate.parse("2020-10-19", DATE_TIME_FORMATTER)));
        expected.add(new ProductsDto("r", "orange", 5, LocalDate.parse("2020-11-20", DATE_TIME_FORMATTER)));
        List<ProductsDto> actual = readService.readFromFile(FILE_WITH_CORRECTLY_DATA);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void emptyFileTest() {
        List<ProductsDto> expected = new ArrayList<>();
        List<ProductsDto> actual = readService.readFromFile(EMPTY_DATA);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void fileDoesNotExistTest() {
        readService.readFromFile(WRONG_NAME_FILE);
    }
}
