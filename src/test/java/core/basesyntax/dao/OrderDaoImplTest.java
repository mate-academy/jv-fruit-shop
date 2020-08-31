package core.basesyntax.dao;

import core.basesyntax.model.Order;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImplTest {

    @Test
    public void orderDaoImplTest() {
        OrderDaoImpl actual = new OrderDaoImpl();
        List<Order> expected = new ArrayList<>();
        expected.add(new Order("s", "banana", 100));
        expected.add(new Order("s", "apple", 100));
        expected.add(new Order("s", "orange", 100));
        actual.add(new Order("s", "banana", 100));
        actual.add(new Order("s", "apple", 100));
        actual.add(new Order("s", "orange", 100));
        Assert.assertEquals(expected, actual.getAll());
    }
}
