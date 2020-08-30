package core.basesyntax.service;

import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Map;

public class CsvFileWriterImplTest {
    private static final Integer QUANTITY = 30;
    private static final String KEY = "orange";
    private static CsvFileWriterImpl write;
    private static Map<String, Integer> storage;

    @BeforeClass
    public static void beforeCLass() {
        Storage.addFruit(KEY, QUANTITY);
        storage = Storage.getStockBalance();
        write = new CsvFileWriterImpl();
    }

    @Test(expected = RuntimeException.class)
    public void incorrectPathTest() {
        write.writeToFile(Storage.getStockBalance(), "");
    }

    @Test
    public void fileWroteNormalTest() {
        String path = "src/test/resources/data.csv";
        Assert.assertTrue(write.writeToFile(storage, path));
    }
}
