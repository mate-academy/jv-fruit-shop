package core.basesyntax.dao;

import core.basesyntax.stock.dao.OrderDaoImpl;
import core.basesyntax.stock.db.Storage;
import core.basesyntax.stock.order.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImplTest {
    private static Order order1 = new Order("s", "banana", 100);
    private static Order order2 = new Order("s", "apple", 100);
    private static Order order3 = new Order("s", "orange", 100);
    List<Order> orders = new ArrayList<>();



    OrderDaoImpl orderDao = new OrderDaoImpl();


    @Test
    public void orderDaoImplTest() {
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        Storage.orders.add(order1);
        Storage.orders.add(order2);
        Storage.orders.add(order3);
        orderDao.getAll();
        Assert.assertEquals(orders,Storage.orders);

    }
}
