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
    private static final Fruit BANANA_FRUIT = new Fruit("banana", 100, LocalDate.now());
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
        storage.add(BANANA_FRUIT);
        buyTrading.trade(BANANA_FRUIT);
        Fruit expectedFruit = new Fruit("banana", 0, BANANA_FRUIT.getShelfLife());
        Fruit actualFruit = storage.getByName(BANANA_FRUIT.getName());
        int actualSize = storage.size();
        Assert.assertEquals(expectedFruit, actualFruit);
        Assert.assertEquals(1, actualSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void buyFruitWhenStorageEmptyTest() {
        buyTrading.trade(BANANA_FRUIT);
    }

    @Test(expected = NullPointerException.class)
    public void buyFruitNullTest() {
        buyTrading.trade( null);
    }
}
