package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitStorageTest {

    private static FruitStorage fruitStorage;
    private static Fruit fruitA;
    private static Fruit fruitB;

    @Before
    public void setUp() {
        fruitStorage = new FruitStorage();
        fruitA = new Fruit();
        fruitA.setName("banana");
        fruitA.setDate(LocalDate.of(2020, 8, 20));
        fruitB = new Fruit();
        fruitB.setName("apple");
        fruitB.setDate(LocalDate.of(2020, 8, 24));
    }

    @Test
    public void addTestOk() {
        int expected = 1;
        int actual;
        fruitStorage.add(fruitA);
        actual = fruitStorage.size();
        Assert.assertEquals(expected, actual);
        expected++;
        fruitStorage.add(fruitA);
        actual = fruitStorage.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTestOk() {
        int expected = 2;
        int actual;
        fruitStorage.add(fruitA);
        fruitStorage.add(fruitB);

        actual = fruitStorage.size();
        Assert.assertEquals(expected, actual);

        fruitStorage.remove(fruitA);
        expected--;
        actual = fruitStorage.size();
        Assert.assertEquals(expected, actual);

        fruitStorage.remove(fruitB);
        expected--;
        actual = fruitStorage.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getListOfFruitsTestOk() {
        fruitStorage.add(fruitA);
        fruitStorage.add(fruitB);
        List<Fruit> actual = fruitStorage.getListOfFruits();
        List<Fruit> expected = new ArrayList<>();
        expected.add(fruitA);
        expected.add(fruitB);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateStocksOk() {
        List<String> expected = new ArrayList<>();
        expected.add("banana,3");
        expected.add("apple,2");
        fruitStorage.add(fruitA);
        fruitStorage.add(fruitA);
        fruitStorage.add(fruitA);
        fruitStorage.add(fruitB);
        fruitStorage.add(fruitB);
        List<String> actual = fruitStorage.getReport();
        Assert.assertEquals(expected, actual);
    }
}
