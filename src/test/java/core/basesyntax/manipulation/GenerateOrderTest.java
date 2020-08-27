package core.basesyntax.manipulation;

import core.basesyntax.stock.manipulation.GenerateOrder;
import core.basesyntax.stock.order.Order;
import org.junit.Assert;
import org.junit.Test;

public class GenerateOrderTest {
    public final static String EXAMPLE = "s,banana,100,2020-10-17";
    private static Order expect = new Order("s", "banana", 100);
    private final static String[] line = EXAMPLE.split(",");
    GenerateOrder order = new GenerateOrder();

    @Test
    public void shouldGenerateOrderTestTest() {
        Order actual =  order.newOrder(line);
        Assert.assertEquals(expect.toString(),actual.toString());
    }
}
