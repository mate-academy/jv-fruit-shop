package core.basesyntax.util;

import core.basesyntax.model.Order;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class GetTotalSumOfFruitTest {
    private final int EXPECTING_RESULT = 51;
    private final static String FRUIT = "banana";

    @Test
    public void shouldGetTotalSumOfFruitTest() {
        List<Order> supplyList = new ArrayList<>();
        GetTotalSumOfFruit getTotalSumOfFruit = new GetTotalSumOfFruit();
        supplyList.add(new Order("s", "banana", 100));
        supplyList.add(new Order("b", "banana", 50));
        supplyList.add(new Order("r", "banana", 1));
        int actual = getTotalSumOfFruit.sum(supplyList, FRUIT);
        Assert.assertEquals(EXPECTING_RESULT, actual);
    }
}
