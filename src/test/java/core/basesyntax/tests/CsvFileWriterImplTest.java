package core.basesyntax.tests;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CsvFileWriterImplTest {
    private static final String REPORT_ALLOCATION = "src/test/resources/testReport.csv";
    private static Map<Fruit, Integer> fruitStorage;
    private static DataWriter dataWriter;

    @Before
    public void beforeAll() {
        fruitStorage = new HashMap<>();
        dataWriter = new CsvFileWriterImpl();
        fruitStorage.put(new Fruit("mango"), 94);
        fruitStorage.put(new Fruit("apple"), 8);
    }

    @Test
    public void makeReport() {
        dataWriter.write(fruitStorage, REPORT_ALLOCATION);
    }

    @After
    public void cleanMap() {
        if (fruitStorage != null) {
            fruitStorage.clear();
        }
    }
}
