package core.basesyntax.service;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import core.basesyntax.FruitBatch;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterServiceTest {
    private static final String PATH_FOR_OUTPUT_FILE = "src/main/resources/test_fruit_transactions.csv";
    static Map<FruitBatch, Integer> fruits = new HashMap<>();
    static FileWriterService writer;

    @BeforeClass
    public static void setUp() {
        writer = new CsvFileWriterService();
        FruitBatch fruitBatch1 = new FruitBatch("jack fruit",
                LocalDate.of(2020, 12, 9));
        FruitBatch fruitBatch2 = new FruitBatch("pomegranate",
                LocalDate.of(2020, 11, 11));
        fruits.put(fruitBatch1, 11);
        fruits.put(fruitBatch2, 2);
    }

    @Test
    public void writeToFile_correctWork() {
        FileWriterService writer = new CsvFileWriterService();
        writer.writeToFile(PATH_FOR_OUTPUT_FILE, fruits);
        File file = new File("src/main/resources/test_fruit_transactions_output.csv");
        Assert.assertTrue(file.exists());
    }

    @Test
    public void formatData_correctWork() {
        Map<String, Integer> actualResult = writer.formatData(fruits);
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("jack fruit", 11);
        expectedResult.put("pomegranate", 2);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
