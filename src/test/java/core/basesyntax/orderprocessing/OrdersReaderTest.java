package core.basesyntax.orderprocessing;

import core.basesyntax.customexceptions.BadFileFormatting;
import core.basesyntax.entries.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class OrdersReaderTest {
    private final String DEFAULT_PATH = "C:\\Users\\User\\IdeaProjects\\JUnit_Practise\\src\\test\\resources\\";
    private final String BIG_TEST = "bigTest.csv";
    private final String SMALL_TEST = "smallTest.csv";
    private final String EMPTY_TEST = "emptyTest.csv";
    private final String WITHOUT_HEADER = "withoutHeader.csv";
    private final String INVALID_PATH = "justAJoke";

    private OrdersReader ordersReader;

    @Before
    public void setUp() {
        ordersReader = new OrdersReader();
    }

    @Test
    public void readSmallTest() {
        List<Order> orders = ordersReader.formOrders(DEFAULT_PATH + SMALL_TEST);
        Assert.assertFalse(orders.isEmpty());
    }

    @Test
    public void readBigTest() {
        List<Order> orders = ordersReader.formOrders(DEFAULT_PATH + BIG_TEST);
        Assert.assertFalse(orders.isEmpty());
    }

    @Test(expected = BadFileFormatting.class)
    public void readEmptyTest() {
        ordersReader.formOrders(DEFAULT_PATH + EMPTY_TEST);
    }

    @Test(expected = BadFileFormatting.class)
    public void readWithoutHeaderTest() {
        ordersReader.formOrders(DEFAULT_PATH + WITHOUT_HEADER);
    }

    @Test(expected = RuntimeException.class)
    public void readInvalidTest() {
        ordersReader.formOrders(DEFAULT_PATH + INVALID_PATH);
    }
}
