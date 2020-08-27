package core.basesyntax;

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
        List<Operation> expected = new ArrayList<>();
        expected.add(new Operation("s", "banana", 100, LocalDate.parse("2020-10-17")));
        expected.add(new Operation("b", "banana", 13, LocalDate.parse("2020-10-15")));
        expected.add(new Operation("r", "banana", 10, LocalDate.parse("2020-10-17")));
        expected.add(new Operation("s", "apple", 300, LocalDate.parse("2020-10-18")));

        List<Operation> actual = reader.readFile("src/main/resources/NormalInput.csv");

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void notCsvFileTest() {
        reader.readFile("src/main/resources/NotCsvFile.txt");
    }

    @Test (expected = RuntimeException.class)
    public void fileDoesNotExistTest() {
        reader.readFile("notExistingFile.csv");
    }


}
