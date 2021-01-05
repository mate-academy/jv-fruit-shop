package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class CsvFileWriterTest {
    private static FileWriter writer = new CsvFileWriter();
    private static final String PATH = "src/test/java/resources/fruit-writeTest.csv";
    private static Map<String, Integer> report = new HashMap<>();

    @Test
    public void write_ok() {
        report.put("banana", 50);
        writer.createReportFile(report, PATH);
        String expected = "fruit,quantity"
                + System.lineSeparator()
                + "banana,50";

        String actual = reader(PATH);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void write_notOk() {
        writer.createReportFile(report, "");
    }

    private static String reader(String path) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            bufferedReader.lines()
                    .forEach(s -> result.append(s).append(System.lineSeparator()));
            return result.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException("Invalid file or path to it");
        }
    }
}
