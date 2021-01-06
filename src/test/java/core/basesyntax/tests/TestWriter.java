package core.basesyntax.tests;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitFileWriter;
import core.basesyntax.service.impl.CsvFileWriter;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWriter {
    private static final Map<Fruit, Integer> data = new HashMap<>();
    private static final FruitFileWriter writer = new CsvFileWriter();
    private static final String PATH_FILE = "src/main/resourcestests/fruitReport.csv";

    @Before
    public void putDataInData() {
        Fruit banana = new Fruit("banana");
        Fruit lime = new Fruit("lime");
        data.put(banana, 20);
        data.put(lime, 100);
    }

    @After
    public void cleanData() {
        if (data != null) {
            data.clear();
        }
    }

    @Test
    public void createReport() {
        writer.writeToFile(data, PATH_FILE);
    }
}
