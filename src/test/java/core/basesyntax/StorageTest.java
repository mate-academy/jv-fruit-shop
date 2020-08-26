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
    public void getFruitByName() {
        storage.add(BANANA_FRUIT);
        Fruit actual = storage.getByName(BANANA_FRUIT.getName());
        Assert.assertEquals(actual, BANANA_FRUIT);
    }

    @Test
    public void getFruitByName_Null() {
        storage.add(BANANA_FRUIT);
        try {
            storage.getByName(null);
        } catch (NoSuchElementException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void getFruitByName_WrongName() {
        storage.add(BANANA_FRUIT);
        try {
            storage.getByName("test");
        } catch (NoSuchElementException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void addNull() {
        try {
            storage.add(null);
        } catch (NullPointerException ignored) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void addOneFruit() {
        storage.add(BANANA_FRUIT);
        Fruit actual = storage.getByName(BANANA_FRUIT.getName());
        Assert.assertEquals(1, storage.size());
        Assert.assertEquals(BANANA_FRUIT, actual);
    }

    @Test
    public void addTwoIdenticalFruit() {
        storage.add(BANANA_FRUIT);
        storage.add(BANANA_FRUIT);
        Assert.assertEquals(1, storage.size());
        int expectedQuantity = BANANA_FRUIT.getQuantity() + BANANA_FRUIT.getQuantity();
        int actualQuantity = storage.getByName(BANANA_FRUIT.getName()).getQuantity();
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void addTwoDifferentFruits() {
        storage.add(BANANA_FRUIT);
        storage.add(ORANGE_FRUIT);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void removeBanana() {
        storage.add(BANANA_FRUIT);
        Fruit removableFruit = new Fruit("banana", 40, DEFAULT_DATE);
        storage.remove(removableFruit);
        Fruit expected = new Fruit("banana", 60, DEFAULT_DATE);
        Fruit actual = storage.getByName(BANANA_FRUIT.getName());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeAllBanana() {
        storage.add(BANANA_FRUIT);
        Fruit removableFruit = new Fruit("banana", 100, DEFAULT_DATE);
        storage.remove(removableFruit);
        Fruit expected = new Fruit("banana", 0, DEFAULT_DATE);
        Fruit actual = storage.getByName(BANANA_FRUIT.getName());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeMoreBananasThanAreInStorage() {
        storage.add(BANANA_FRUIT);
        Fruit removableFruit = new Fruit("banana", 101, DEFAULT_DATE);
        try {
            storage.remove(removableFruit);
        } catch (InvalidParameterException e) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void removeNull() {
        try {
            storage.remove(null);
        } catch (NullPointerException ignored) {
            return;
        }
        Assert.fail();
    }

    @Test
    public void getAllFruits() {
        storage.add(BANANA_FRUIT);
        storage.add(ORANGE_FRUIT);
        storage.add(BANANA_FRUIT);
        storage.remove(new Fruit("banana", 41, LocalDate.now()));
        storage.add(new Fruit("kiwi", 145, LocalDate.now()));
        storage.remove(new Fruit("orange", 7, LocalDate.now()));
        List<Fruit> fruits = storage.getAll();
        Assert.assertEquals(3, fruits.size());
    }
}