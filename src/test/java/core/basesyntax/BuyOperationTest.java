package core.basesyntax;

import core.basesyntax.service.impl.BuyOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BuyOperationTest {

    private BuyOperation operation;
    private FruitStorage fruitStorage;
    private Fruit fruit17;
    private Fruit fruit18;
    private Fruit fruit19;

    @Before
    public void createFruitsAndStorage() {
        fruitStorage = new FruitStorage();
        operation = new BuyOperation(fruitStorage);
        fruit17 = new Fruit();
        fruit17.setName("banana");
        fruit17.setDate(LocalDate.parse("2020-10-17"));
        fruit18 = new Fruit();
        fruit18.setName("banana");
        fruit18.setDate(LocalDate.parse("2020-10-18"));
        fruit19 = new Fruit();
        fruit19.setName("banana");
        fruit19.setDate(LocalDate.parse("2020-10-19"));
    }

    @Test
    public void applyTestOk() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(fruit18);
        expected.add(fruit19);
        fruitStorage.add(fruit17);
        fruitStorage.add(fruit18);
        fruitStorage.add(fruit19);
        operation.apply(fruit18);
        List<Fruit> actual = fruitStorage.getListOfFruits();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void enoughFreshTestOk() {
        fruitStorage.add(fruit17);
        fruitStorage.add(fruit18);
        fruitStorage.add(fruit19);
        Assert.assertTrue(operation.enoughFresh("banana", LocalDate.parse("2020-10-18"), 1));
    }

    @Test (expected = RuntimeException.class)
    public void enoughFreshTestNotEnough() {
        fruitStorage.add(fruit17);
        fruitStorage.add(fruit18);
        fruitStorage.add(fruit19);
        boolean a = operation.enoughFresh("banana", LocalDate.parse("2020-10-18"), 3);
        System.out.println(fruitStorage.getListOfFruits().size());
        System.out.println(a);
    }
}