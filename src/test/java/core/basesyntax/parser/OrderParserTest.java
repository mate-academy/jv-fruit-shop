package core.basesyntax.parser;

import core.basesyntax.model.Order;
import org.junit.Assert;
import org.junit.Test;

public class OrderParserTest {
    private static final String FIRST_EXAMPLE
            = "s,banana,100,2020-10-17";
    private Order expected
            = new Order("s", "banana", 100);

    @Test
    public void orderParseAndCreateTest() {
        OrderParser dataParse = new OrderParser();
        Order actual = dataParse.parseNewOrder(FIRST_EXAMPLE);
        Assert.assertEquals(expected, actual);
    }
}
