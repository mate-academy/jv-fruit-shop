package core.basesyntax.shop.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.shop.Trading;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;

public class BuyTradingImplTest {
    private static final Fruit BANANA_FRUIT = new Fruit("banana", LocalDate.now());
    private static Trading buyTrading;
    private static Storage storage;

    @BeforeClass
    public static void setup() {
        storage = new Storage();
        buyTrading = new BuyTradingImpl(storage);
    }

    @After
    public void after() {
        storage.clear();
    }

    @Test
    public void buyFruitTest() {
        storage.add(BANANA_FRUIT, 100);
        buyTrading.trade(BANANA_FRUIT, 100);
        Fruit expectedFruit = new Fruit("banana", BANANA_FRUIT.getShelfLife());
        Fruit actualFruit = storage.getAll().get(0).getFruit();
        int actualSize = storage.size();
        Assert.assertEquals(expectedFruit, actualFruit);
        Assert.assertEquals(1, actualSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buyFruitWhenStorageEmptyTest() {
        buyTrading.trade(BANANA_FRUIT, 100);
    }

    @Test(expected = NullPointerException.class)
    public void buyFruitNullTest() {
        buyTrading.trade( null, 0);
    }
}
