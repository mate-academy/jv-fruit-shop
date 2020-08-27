package core.basesyntax.parser;

import core.basesyntax.stock.parser.OrderParse;
import org.junit.Assert;
import org.junit.Test;


public class OrderParseTest {
    public final static String FIRST_EXAMPLE = "s,banana,100,2020-10-17";

    @Test
    public void orderParseTest() {
        OrderParse dataParse = new OrderParse();
        String line = FIRST_EXAMPLE;
        String[] actual = dataParse.parse(line);
        String[] expected = line.split(",");
        Assert.assertEquals(expected, actual);
    }
}

