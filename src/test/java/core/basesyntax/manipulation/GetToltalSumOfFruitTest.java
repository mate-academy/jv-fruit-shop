package core.basesyntax.manipulation;

import core.basesyntax.stock.manipulation.GetTotalSumOfFruit;
import core.basesyntax.stock.order.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetToltalSumOfFruitTest {
    private static Order order1 = new Order("s", "banana", 100);
    private static Order order2 = new Order("b", "banana", 50);
    private static Order order3 = new Order("r", "banana", 1);
    private static int EXPECTING_RESULT = 51;
    public final static String FRUIT = "banana";
    private static List<Order> supplyList = new ArrayList<>();
    GetTotalSumOfFruit getTotalSumOfFruit = new GetTotalSumOfFruit();

    @Test
    public void shouldGetTotalSumOfFruitTest() {
        supplyList.add(order1);
        supplyList.add(order2);
        supplyList.add(order3);
        int actual = getTotalSumOfFruit.sum(supplyList, FRUIT);
        Assert.assertEquals(EXPECTING_RESULT, actual);
    }
}
