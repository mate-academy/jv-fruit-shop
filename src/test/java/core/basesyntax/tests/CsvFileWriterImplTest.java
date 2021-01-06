package core.basesyntax.tests;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CsvFileWriterImplTest {
    private static final String REPORT_ALLOCATION = "src/test/resources/testReport.csv";
    private static Map<Fruit, Integer> fruitStorage;
    private static DataWriter dataWriter;
    private static List<String> expectedData;

    @Before
    public void beforeAll() {
        fruitStorage = new HashMap<>();
        dataWriter = new CsvFileWriterImpl();
        expectedData = new ArrayList<>();
        expectedData.add("fruit,quantity");
        expectedData.add("apple,8");
        expectedData.add("mango,94");
        fruitStorage.put(new Fruit("mango"), 94);
        fruitStorage.put(new Fruit("apple"), 8);
    }

    @Test
    public void makeReport() {
        List<String> actualData;
        dataWriter.write(fruitStorage, REPORT_ALLOCATION);
        try {
            actualData = Files.readAllLines(Path.of(REPORT_ALLOCATION));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file from " + REPORT_ALLOCATION);
        }
        assertEquals(expectedData,actualData);
    }

    @After
    public void cleanMap() {
        if (fruitStorage != null) {
            fruitStorage.clear();
        }
    }
}
