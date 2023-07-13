package db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CsvFileReader;
import service.GenerateReport;

class FruitStorageTest {
    private static final String VALID_INPUT_FILE = "input.csv";

    private CsvFileReader reader;
    private GenerateReport report;

    @BeforeEach
    void setUp() {
        reader = new CsvFileReader();
        report = new GenerateReport();
    }

    @Test
    void updateStock_ok() {
        List<String> fruitData = reader.readCsvFile(VALID_INPUT_FILE);

        report.calculateFruitsStock(fruitData);

        Map<String,Integer> expectedStock = new HashMap<>();
        expectedStock.put("banana", 152);
        expectedStock.put("apple", 90);

        Map<String,Integer> actualStock = report.getStock();

        assertEquals(expectedStock, actualStock,
                "Actual and expected stocks must be equals");
    }
}
