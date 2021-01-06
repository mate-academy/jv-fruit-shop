package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterImplTest {
    private static final String EXPECTED_REPORT = "src/test/resources/expected_file";
    private static final String PATH_TO_WRITE = "src/test/resources/file_to_write";
    private static Map<Fruit, Integer> fruits = new HashMap<>();
    private static CsvFileWriter fileWriter = new CsvFileWriterImpl();

    @BeforeClass
    public static void setUp() {
        fruits.put(new Fruit("banana"), 731);
        fruits.put(new Fruit("apple"), 157);
    }

    @Test
    public void fileWritterCheck_Ok() {
        fileWriter.writeReport(PATH_TO_WRITE, fruits);
        List<String> actualData;
        List<String> expectedData;
        try {
            actualData = Files.readAllLines(Path.of(PATH_TO_WRITE));
            expectedData = Files.readAllLines(Path.of(EXPECTED_REPORT));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from files" + PATH_TO_WRITE, e);
        }
        Assert.assertEquals(actualData.size(), expectedData.size());
        Assert.assertEquals(expectedData, actualData);
    }
}
