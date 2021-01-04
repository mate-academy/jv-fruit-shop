package core.basesyntax.operations;

import core.basesyntax.storage.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class SupplyOperationTest {
    private static final Integer QUANTITY = 30;
    private static final Integer EXPECTED_QUANTITY = 60;
    private static final String FRUIT = "orange";
    private static final String DATE = "2020-10-12";
    private static SupplyOperation supply;

    @BeforeClass
    public static void beforeClass() {
        supply = new SupplyOperation();
    }

    @Before
    public void clearStorage() {
        Storage.getStockBalance().clear();
    }

    @Test
    public void supplyNormalTest() {
        Storage.addFruit(FRUIT, QUANTITY);
        supply.provideOperation(FRUIT, QUANTITY, DATE);
        Map<String, Integer> storage = Storage.getStockBalance();
        Assert.assertEquals(EXPECTED_QUANTITY, storage.get(FRUIT));
    }

    @Test
    public void supplyNewFruitTest() {
        System.out.println(Storage.getStockBalance());
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put(FRUIT, QUANTITY);
        supply.provideOperation(FRUIT, QUANTITY, DATE);
        Assert.assertEquals(testMap, Storage.getStockBalance());
    }
}
