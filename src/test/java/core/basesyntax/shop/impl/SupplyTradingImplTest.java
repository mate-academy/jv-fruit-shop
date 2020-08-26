package core.basesyntax.shop.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

public class SupplyTradingImplTest {
    private static final Fruit BANANA_FRUIT = new Fruit("banana", 100, LocalDate.now());
    private static Trading supplyTrading;
    private static Storage storage;

    @BeforeClass
    public static void setup() {
        supplyTrading = new SupplyTradingImpl();
        storage = new Storage();
    }

    @After
    public void after() {
        storage.clear();
    }

    @Test
    public void supplyFruitTest() {
        storage.add(BANANA_FRUIT);
        supplyTrading.trade(storage, BANANA_FRUIT);
        Fruit expectedFruit = new Fruit("banana", 200, BANANA_FRUIT.getShelfLife());
        Fruit actualFruit = storage.getByName(BANANA_FRUIT.getName());
        int actualSize = storage.size();
        Assert.assertEquals(expectedFruit, actualFruit);
        Assert.assertEquals(1, actualSize);
    }

    @Test
    public void supplyFruitWhenStorageEmptyTest() {
        supplyTrading.trade(storage, BANANA_FRUIT);
        Fruit actualFruit = storage.getByName(BANANA_FRUIT.getName());
        int actualSize = storage.size();
        Assert.assertEquals(BANANA_FRUIT, actualFruit);
        Assert.assertEquals(1, actualSize);
    }

    @Test(expected = NullPointerException.class)
    public void supplyFruitNullTest() {
        supplyTrading.trade(null, null);
    }
}