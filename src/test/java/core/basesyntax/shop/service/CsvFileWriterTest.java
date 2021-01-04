package core.basesyntax.shop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.shop.model.Fruit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CsvFileWriterTest {
    public static final String REPORT_PATH = "src/test/resources/report-fruit.csv";
    public static final String EXPECTED_REPORT_PATH = "src/test/resources/ExpectedReport.csv";
    private static Map<Fruit, Integer> fruitReport;
    private static FileWriter writer;

    @BeforeAll
    public static void beforeAll() {
        writer = new CsvFileWriter();
        fruitReport = new HashMap<>();
        fruitReport.put(new Fruit("Banana"), 132);
        fruitReport.put(new Fruit("Apple"), 666);
    }

    @Test
    public void createReportFile() {
        writer.createReportFile(fruitReport, REPORT_PATH);
        List<String> actualLines;
        List<String> expectedLines;
        try {
            actualLines = Files.readAllLines(Path.of(REPORT_PATH));
            expectedLines = Files.readAllLines(Path.of(EXPECTED_REPORT_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file: " + REPORT_PATH);
        }
        assertEquals(expectedLines, actualLines);
    }
}
