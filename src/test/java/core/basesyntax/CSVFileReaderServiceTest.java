package core.basesyntax;

import core.basesyntax.fileservice.CSVFileReaderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CSVFileReaderServiceTest {
    private static final String MONDAY = "src/test/resources/data_for_monday.csv";
    private static final String TUESDAY = "src/test/resources/data_for_tuesday.csv";
    private static final String WEDNESDAY = "src/test/resources/data_for_wednesday.csv";
    private static final String THURSDAY = "src/test/resources/data_for_thursday.csv";
    private static final String FRIDAY = "src/test/resources/data_for_friday.csv";
    private static final String SATURDAY = "src/test/resources/data_for_saturday.csv";
    private static final String NON_CSV = "src/test/resources/non_csv.txt";
    private static CSVFileReaderService csvFileReaderService;

    @BeforeAll
    static void beforeAll() {
        csvFileReaderService = new CSVFileReaderService();
    }

    @Test
    void readFromNonCSVFile_NotOk() {
        Assertions.assertThrows(RuntimeException.class, () -> csvFileReaderService.readFromFile(NON_CSV));
    }

    @Test
    void readFromFile_Ok() {
        List<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"b", "banana", "20"});
        expected.add(new String[]{"b", "apple", "100"});
        expected.add(new String[]{"s", "banana", "100"});
        expected.add(new String[]{"p", "banana", "13"});
        expected.add(new String[]{"r", "apple", "10"});
        expected.add(new String[]{"p", "apple", "20"});
        expected.add(new String[]{"p", "banana", "5"});
        expected.add(new String[]{"s", "banana", "50"});
        List<String[]> actual = csvFileReaderService.readFromFile(MONDAY);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}