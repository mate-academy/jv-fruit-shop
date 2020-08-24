package core.basesyntax;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalCsvFileWriterTest {
    private static final String FILE_HEADER = "fruit,quantity";
    private static final String FILE_LINE_ONE = "banana,97";
    private static final String FILE_LINE_TWO = "apple,100";
    private static final String OUTPUT_FILE = "src/test/resources/stock.csv";
    private static Map<String, Integer> testMap;

    @BeforeClass
    public static void beforeClass() {
        testMap = new HashMap<>();
        testMap.put("banana", 97);
        testMap.put("apple", 100);
    }

    @Test
    public void createStockFile() throws IOException {
        CsvFileWriter writer = new LocalCsvFileWriter(OUTPUT_FILE);
        writer.createStockFile(testMap);
        List<String> testFileLines = Files.readAllLines(Path.of(OUTPUT_FILE));
        Assert.assertEquals(3, testFileLines.size());
        Assert.assertEquals(FILE_HEADER, testFileLines.get(0));
        Assert.assertEquals(FILE_LINE_ONE, testFileLines.get(1));
        Assert.assertEquals(FILE_LINE_TWO, testFileLines.get(2));
    }

    @AfterClass
    public static void afterClass() throws IOException {
        Files.deleteIfExists(Path.of(OUTPUT_FILE));
    }
}
