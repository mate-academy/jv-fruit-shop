package core.basesyntax;

import core.basesyntax.service.BuyOperation;
import core.basesyntax.service.FruitDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class BuyOperationTest {
    private static Map<String, Map<String, Integer>> store;
    private static Map<String, Integer> bananaEntity;
    private FruitDto fruits;

    @BeforeClass
    public static void beforeClass() {
        store = new HashMap<>();
        bananaEntity = new HashMap<>();
    }

    @Test
    public void buyMoreThenAvailable() {
        fruits = new FruitDto("b", "banana", 200, "2020-08-26");
        bananaEntity.put("2020-08-26", 12);
        store.put("banana", bananaEntity);
        BuyOperation buyOperation = new BuyOperation();
        boolean result = buyOperation.operations(store, fruits);
        Assert.assertFalse(result);
        Assert.assertSame(12, store.get("banana").get("2020-08-26"));
        Assert.assertEquals(1, store.size());
    }
}
