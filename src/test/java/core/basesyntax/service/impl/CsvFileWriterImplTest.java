package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CsvFileWriterImplTest {
    private CsvFileWriter csvFileWriter;

    @Before
    public void setUp() {
        csvFileWriter = new CsvFileWriterImpl();
    }

    @Test(expected = RuntimeException.class)
    public void incorrectFilePath_notOk() {
        String filePath = "";
        csvFileWriter.reportFile(Storage.fruitReport, filePath);
    }

    @Test
    public void correctWriteFile_Ok() {
        String filePath = "src/test/resources/correct_fruit_report.csv";

        Map<Fruit, Integer> fruitReport = new HashMap<>();
        fruitReport.put(new Fruit("banana"), 50);
        fruitReport.put(new Fruit("apple"), 12);

        csvFileWriter.reportFile(fruitReport, filePath);

        List<String> expected = List.of("banana,50", "apple,12");
        List<String> actually = readFromFile(filePath);
        Assert.assertEquals(expected, actually);
    }

    private List<String> readFromFile(String filePath) {
        List<String> readFromFile = new ArrayList<>();
        String value;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((value = reader.readLine()) != null) {
                readFromFile.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return readFromFile;
    }
}
