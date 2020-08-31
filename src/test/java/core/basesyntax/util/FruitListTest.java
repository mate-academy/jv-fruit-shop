package core.basesyntax.util;

import core.basesyntax.model.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FruitListTest {

    @Test
    public void createListOfFruitTest() {
        FruitList fruitList = new FruitList();
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("s", "banana", 100));
        orders.add(new Order("s", "banana", 100));
        orders.add(new Order("s", "apple", 100));
        orders.add(new Order("s", "orange", 100));
        List<String> actual = fruitList.createListOfFruit(orders);
        List<String> expected = new ArrayList<>();
        expected.add("banana");
        expected.add("apple");
        expected.add("orange");
        Assert.assertEquals(expected, actual);
    }
}
