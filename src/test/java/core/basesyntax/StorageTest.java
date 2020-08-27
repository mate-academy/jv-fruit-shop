package core.basesyntax;

import core.basesyntax.model.Fruit;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class StorageTest {
    private static final LocalDate DEFAULT_DATE = LocalDate.of(2020, 1, 1);
    private static final Fruit BANANA_FRUIT = new Fruit("banana", 100, DEFAULT_DATE);
    private static final Fruit ORANGE_FRUIT = new Fruit("orange", 50, DEFAULT_DATE);
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
    public void getFruitByNameTest() {
        storage.add(BANANA_FRUIT);
        Fruit actual = storage.getByName(BANANA_FRUIT.getName());
        Assert.assertEquals(actual, BANANA_FRUIT);
    }

    @Test(expected = NoSuchElementException.class)
    public void getFruitByName_NullTest() {
        storage.getByName(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void getFruitByName_WrongNameTest() {
        storage.getByName("test");
    }

    @Test(expected = NullPointerException.class)
    public void addNullTest() {
        storage.add(null);
    }

    @Test
    public void addOneFruitTest() {
        storage.add(BANANA_FRUIT);
        Fruit actual = storage.getByName(BANANA_FRUIT.getName());
        Assert.assertEquals(1, storage.size());
        Assert.assertEquals(BANANA_FRUIT, actual);
    }

    @Test
    public void addTwoIdenticalFruitTest() {
        storage.add(BANANA_FRUIT);
        storage.add(BANANA_FRUIT);
        Assert.assertEquals(1, storage.size());
        int expectedQuantity = BANANA_FRUIT.getQuantity() + BANANA_FRUIT.getQuantity();
        int actualQuantity = storage.getByName(BANANA_FRUIT.getName()).getQuantity();
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void addTwoDifferentFruitsTest() {
        storage.add(BANANA_FRUIT);
        storage.add(ORANGE_FRUIT);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void removeBananaTest() {
        storage.add(BANANA_FRUIT);
        Fruit removableFruit = new Fruit("banana", 40, DEFAULT_DATE);
        storage.remove(removableFruit);
        Fruit expected = new Fruit("banana", 60, DEFAULT_DATE);
        Fruit actual = storage.getByName(BANANA_FRUIT.getName());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeAllBananaTest() {
        storage.add(BANANA_FRUIT);
        Fruit removableFruit = new Fruit("banana", 100, DEFAULT_DATE);
        storage.remove(removableFruit);
        Fruit expected = new Fruit("banana", 0, DEFAULT_DATE);
        Fruit actual = storage.getByName(BANANA_FRUIT.getName());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = InvalidParameterException.class)
    public void removeMoreBananasThanAreInStorageTest() {
        storage.add(BANANA_FRUIT);
        Fruit removableFruit = new Fruit("banana", 101, DEFAULT_DATE);
        storage.remove(removableFruit);
    }

    @Test(expected = NullPointerException.class)
    public void removeNullTest() {
        storage.remove(null);
    }

    @Test
    public void getAllFruitsTest() {
        storage.add(BANANA_FRUIT);
        storage.add(ORANGE_FRUIT);
        storage.add(BANANA_FRUIT);
        storage.remove(new Fruit("banana", 41, BANANA_FRUIT.getShelfLife()));
        storage.add(new Fruit("kiwi", 145, LocalDate.now()));
        storage.remove(new Fruit("orange", 7, ORANGE_FRUIT.getShelfLife()));
        List<Fruit> fruits = storage.getAll();
        Assert.assertEquals(3, fruits.size());
    }
}
