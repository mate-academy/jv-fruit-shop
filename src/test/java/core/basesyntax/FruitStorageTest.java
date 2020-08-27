package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class FruitStorageTest {

    @Test
    public void clearStock_correctWork() {
        Map<FruitBatch, Integer> emptyStock = new HashMap<>();
        FruitStorage.clearStock();
        Assert.assertEquals(emptyStock, FruitStorage.getFruits());
    }
}
