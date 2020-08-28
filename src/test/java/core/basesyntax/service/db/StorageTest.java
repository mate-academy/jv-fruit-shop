package core.basesyntax.service.db;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.time.LocalDate;

public class StorageTest {
    private static final LocalDate DEFAULT_DATE = LocalDate.of(2020, 1, 1);
    private static final Fruit BANANA_FRUIT = new Fruit("banana", DEFAULT_DATE);
    private static final Fruit ORANGE_FRUIT = new Fruit("orange", DEFAULT_DATE);
    private static Storage storage;

    @BeforeClass
    public static void setup() {
        storage = new Storage();
    }

    @After
    public void after() {
        storage.clear();
    }

    @Test
    public void addOneFruitTest() {
        storage.add(BANANA_FRUIT, 100);
        Fruit actual = storage.getAll().get(0).getFruit();
        Assert.assertEquals(1, storage.size());
        Assert.assertEquals(BANANA_FRUIT, actual);
    }

    @Test
    public void addTwoIdenticalFruitTest() {
        storage.add(BANANA_FRUIT, 100);
        storage.add(BANANA_FRUIT, 100);
        Assert.assertEquals(1, storage.size());
        int actualQuantity = storage.getAll().get(0).getQuantity();
        Assert.assertEquals(200, actualQuantity);
    }

    @Test
    public void addTwoDifferentFruitsTest() {
        storage.add(BANANA_FRUIT, 100);
        storage.add(ORANGE_FRUIT, 100);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void removeBananaTest() {
        storage.add(BANANA_FRUIT, 100);
        storage.remove(BANANA_FRUIT, 40);
        int actual = storage.getAll().get(0).getQuantity();
        Assert.assertEquals(60, actual);
    }

    @Test
    public void removeAllBananaTest() {
        storage.add(BANANA_FRUIT, 100);
        storage.remove(BANANA_FRUIT, 100);
        int actual = storage.getAll().get(0).getQuantity();
        Assert.assertEquals(0, actual);
    }

    @Test(expected = InvalidParameterException.class)
    public void removeMoreBananasThanAreInStorageTest() {
        storage.add(BANANA_FRUIT, 100);
        storage.remove(BANANA_FRUIT, 101);
    }

    @Test
    public void getAllFruitsTest() {
        storage.add(BANANA_FRUIT, 100);
        storage.add(ORANGE_FRUIT, 100);
        storage.add(BANANA_FRUIT, 100);
        storage.remove(BANANA_FRUIT, 100);
        storage.remove(ORANGE_FRUIT, 100);
        int actual = storage.getAll().size();
        Assert.assertEquals(2, actual);
    }
}
