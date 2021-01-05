package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriterService;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterServiceTest {
    private static final String REPORT = "src/test/resources/report.csv";
    private static FileWriterService writerService;

    @BeforeClass
    public static void beforeClass() {
        writerService = new CsvFileWriterService();
    }

    @Test
    public void writeReportForMonday_Ok() {
        Map<Fruit, Integer> balance = new HashMap<>();
        balance.put(new Fruit("banana"), 152);
        balance.put(new Fruit("apple"), 90);
        String report = "src/test/resources/report.csv";
        writerService.writeToFile(balance, report);
        List<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"banana", "152"});
        expected.add(new String[]{"apple", "90"});
        List<String[]> actual;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(REPORT));
            actual = csvReader.readAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Incorrect path: " + REPORT, e);
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void writeReportForTuesday_Ok() {
        Map<Fruit, Integer> balance = new HashMap<>();
        balance.put(new Fruit("banana"), 349);
        String report = "src/test/resources/report.csv";
        writerService.writeToFile(balance, report);
        List<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"banana", "349"});
        List<String[]> actual;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(REPORT));
            actual = csvReader.readAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Incorrect path: " + REPORT, e);
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void writeReportForWednesday_Ok() {
        Map<Fruit, Integer> balance = new HashMap<>();
        balance.put(new Fruit("banana"), 325);
        balance.put(new Fruit("apple"), 200);
        balance.put(new Fruit("orange"), 210);
        String report = "src/test/resources/report.csv";
        writerService.writeToFile(balance, report);
        List<String[]> expected = new ArrayList<>();
        expected.add(new String[]{"banana", "325"});
        expected.add(new String[]{"apple", "200"});
        expected.add(new String[]{"orange", "210"});
        List<String[]> actual;
        try {
            CSVReader csvReader = new CSVReader(new FileReader(REPORT));
            actual = csvReader.readAll();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Incorrect path: " + REPORT, e);
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
