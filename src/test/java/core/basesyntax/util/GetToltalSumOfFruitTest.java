package core.basesyntax.util;

import core.basesyntax.order.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetToltalSumOfFruitTest {
    private Order order1 = new Order("s", "banana", 100);
    private Order order2 = new Order("b", "banana", 50);
    private Order order3 = new Order("r", "banana", 1);
    private int EXPECTING_RESULT = 51;
    private final static String FRUIT = "banana";
    private List<Order> supplyList = new ArrayList<>();

    @Test
    public void shouldGetTotalSumOfFruitTest() {
        GetTotalSumOfFruit getTotalSumOfFruit = new GetTotalSumOfFruit();
        supplyList.add(order1);
        supplyList.add(order2);
        supplyList.add(order3);
        int actual = getTotalSumOfFruit.sum(supplyList, FRUIT);
        Assert.assertEquals(EXPECTING_RESULT, actual);
    }
}
