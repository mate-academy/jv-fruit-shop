package core.basesyntax.shop.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

public class RefundsTradingImplTest {
    private static final Fruit BANANA_FRUIT = new Fruit("banana", LocalDate.now());
    private static Trading refundsTrading;
    private static Storage storage;

    @BeforeClass
    public static void setup() {
        storage = new Storage();
        refundsTrading = new RefundsTradingImpl(storage);
    }

    @After
    public void after() {
        storage.clear();
    }

    @Test
    public void refundsFruitTest() {
        storage.add(BANANA_FRUIT, 100);
        refundsTrading.trade(BANANA_FRUIT, 100);
        int actualQuantity = storage.getAll().get(0).getQuantity();
        int actualSize = storage.size();
        Assert.assertEquals(200, actualQuantity);
        Assert.assertEquals(1, actualSize);
    }

    @Test
    public void refundsFruitWhenStorageEmptyTest() {
        refundsTrading.trade(BANANA_FRUIT, 100);
        int actualQuantity = storage.getAll().get(0).getQuantity();
        int actualSize = storage.size();
        Assert.assertEquals(100, actualQuantity);
        Assert.assertEquals(1, actualSize);
    }

    @Test(expected = RuntimeException.class)
    public void refundsFruitNullTest() {
        refundsTrading.trade(null, 0);
    }
}
