package core.basesyntax;

import core.basesyntax.service.impl.ReportMaker;
import core.basesyntax.service.impl.StrategyCreatorImpl;
import core.basesyntax.service.interfaces.StrategyCreator;
import core.basesyntax.service.operations.Operation;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportMakerTest {
    private static ReportMaker reportMaker;

    @BeforeClass
    public static void setUp() {
        Storage.storage = new HashMap<>();
        StrategyCreator strategyCreator = new StrategyCreatorImpl();
        Map<String, Operation> strategy = strategyCreator.createStrategy();
        reportMaker = new ReportMaker(strategy);
    }

    @Test
    public void doOperationCreateStrategyTest() {
        Storage.storage.put("banana", 10);
        Storage.storage.put("apple", 10);
        String[] record = new String[] {"s", "banana", "10"};

        reportMaker.saveDataToStorage(record);

        Integer expected = 20;
        Integer actual = Storage.storage.get("banana");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void combineOutputTest() {
        Storage.storage.put("key1", 1);
        Storage.storage.put("key2", 2);
        Storage.storage.put("key3", 3);

        String expected = "fruit,quantity" + System.lineSeparator()
                + "key1,1" + System.lineSeparator()
                + "key2,2" + System.lineSeparator() + "key3,3";
        String actual = reportMaker.getDataFromStorage();

        Assert.assertEquals(expected, actual);
    }
}
