package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.service.ReadFileServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTest {
    private static final String NORMAL_FILE_NAME = "src/resources/fruits.csv";
    private static final String EMPTY_FILE = "src/resources/emptyFile.csv";
    private static final String WRONG_NAME_FILE = "wrongName.txt";
    private static ReadFileServiceImpl readFileService;

    @BeforeClass
    public static void BeforeClass() {
        readFileService = new ReadFileServiceImpl();
    }

    @Test
    public void normalInputTest() {
        List<FruitDto> expected = new ArrayList<>();
        expected.add(new FruitDto("s", "banana", 100, LocalDate.parse("2020-10-17", DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        expected.add(new FruitDto("b", "banana", 13, LocalDate.parse("2020-10-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        expected.add(new FruitDto("r", "banana", 10, LocalDate.parse("2020-10-17", DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        expected.add(new FruitDto("s", "orange", 100, LocalDate.parse("2020-10-17", DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        expected.add(new FruitDto("b", "orange", 10, LocalDate.parse("2020-10-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        List<FruitDto> actual = readFileService.readFile(NORMAL_FILE_NAME);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void emptyInputTest() {
        List<FruitDto> expected = new ArrayList<>();
        List<FruitDto> actual = readFileService.readFile(EMPTY_FILE);
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void fileDoesNotExistTest() {
        readFileService.readFile(WRONG_NAME_FILE);
    }
}
