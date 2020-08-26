package core.basesyntax.shop.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

public class RefundsTradingImplTest {
    private static final Fruit BANANA_FRUIT = new Fruit("banana", 100, LocalDate.now());
    private static Trading refundsTrading;
    private static Storage storage;

    @BeforeClass
    public static void setup() {
        refundsTrading = new RefundsTradingImpl();
        storage = new Storage();
    }

    @After
    public void after() {
        storage.clear();
    }

    @Test
    public void refundsFruitTest() {
        storage.add(BANANA_FRUIT);
        refundsTrading.trade(storage, BANANA_FRUIT);
        Fruit expectedFruit = new Fruit("banana", 200, BANANA_FRUIT.getShelfLife());
        Fruit actualFruit = storage.getByName(BANANA_FRUIT.getName());
        int actualSize = storage.size();
        Assert.assertEquals(expectedFruit, actualFruit);
        Assert.assertEquals(1, actualSize);
    }

    @Test
    public void refundsFruitWhenStorageEmptyTest() {
        refundsTrading.trade(storage, BANANA_FRUIT);
        Fruit actualFruit = storage.getByName(BANANA_FRUIT.getName());
        int actualSize = storage.size();
        Assert.assertEquals(BANANA_FRUIT, actualFruit);
        Assert.assertEquals(1, actualSize);
    }

    @Test(expected = NullPointerException.class)
    public void refundsFruitNullTest() {
        refundsTrading.trade(null, null);
    }
}