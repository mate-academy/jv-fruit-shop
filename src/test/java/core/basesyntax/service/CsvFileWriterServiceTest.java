package core.basesyntax.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterServiceTest {
    private static final String PATH_FOR_OUTPUT_FILE = "src/main/resources/test_fruit_transactions_report.csv";
    static Map<String, Integer> fruits = new HashMap<>();
    static FileWriterService writer;

    @BeforeClass
    public static void setUp() {
        writer = new CsvFileWriterService();
        fruits.put("banana", 11);
        fruits.put("grapefruit", 2);
    }

    @Test
    public void writeToFile_correctWork() {
        FileWriterService writer = new CsvFileWriterService();
        writer.writeToFile(PATH_FOR_OUTPUT_FILE, fruits);
        File file = new File("src/main/resources/test_fruit_transactions_report.csv");
        Assert.assertTrue(file.exists());
    }
}
