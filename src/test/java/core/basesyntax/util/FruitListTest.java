package core.basesyntax.util;

import core.basesyntax.order.Order;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FruitListTest {
    private static Order order1 = new Order("s", "banana", 100);
    private static Order order1_1 = new Order("s", "banana", 100);
    private static Order order2 = new Order("s", "apple", 100);
    private static Order order3 = new Order("s", "orange", 100);

    @Test
    public void createListOfFruitTest() {
        FruitList fruitList = new FruitList();
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order1_1);
        orders.add(order2);
        orders.add(order3);
        List<String> expected = fruitList.createListOfFruit(orders);
        List<String> actual = new ArrayList<>();
        actual.add("banana");
        actual.add("apple");
        actual.add("orange");
        Assert.assertEquals(expected, actual);
    }
}
