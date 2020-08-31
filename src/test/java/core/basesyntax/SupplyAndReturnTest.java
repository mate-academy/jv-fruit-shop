package core.basesyntax;

import core.basesyntax.service.FruitDto;
import core.basesyntax.service.SupplyAndReturnOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class SupplyAndReturnTest {
    private static Map<String, Map<String, Integer>> store;
    private static SupplyAndReturnOperation supplyAndReturn;

    @BeforeClass
    public static void beforeClass() {
        store = new HashMap<>();
        supplyAndReturn = new SupplyAndReturnOperation();
    }

    @Before
    public void beforeEach() {
        store = new HashMap<>();
    }

    @Test
    public void supplyAndReturnDifferentDates() {
        FruitDto supplyFruit
                = new FruitDto("s", "banana", 120, "2020-08-30");
        FruitDto returnFruit
                = new FruitDto("r", "banana", 10, "2020-08-27");
        boolean resultSupply = supplyAndReturn.operations(store, supplyFruit);
        boolean resultReturn = supplyAndReturn.operations(store, returnFruit);
        Assert.assertTrue(resultSupply);
        Assert.assertTrue(resultReturn);
        Assert.assertEquals(1, store.size());
        Assert.assertEquals(2, store.get("banana").size());
    }
}
