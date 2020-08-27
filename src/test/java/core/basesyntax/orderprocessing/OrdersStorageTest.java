package core.basesyntax.orderprocessing;

import core.basesyntax.entries.FruitPack;
import core.basesyntax.entries.Order;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersStorageTest {
    private FruitPack pack1 = new FruitPack("first", 15, LocalDate.now());
    private FruitPack pack2 = new FruitPack("second", 15, LocalDate.now());
    private FruitPack pack3 = new FruitPack("third", 15, LocalDate.now());
    private Order order1 = new Order(pack1, "s");
    private Order order2 = new Order(pack2, "b");
    private Order order3 = new Order(pack3, "r");
    private List<Order> orders = List.of(order1, order2, order3);
    private OrdersStorage ordersStorage;

    @Before
    public void setUp() {
        ordersStorage = new OrdersStorage();
    }

    @Test
    public void addOrdersOk() {
        assertTrue(ordersStorage.addOrders(orders));
    }

    @Test
    public void addEmptyOrders() {
        assertTrue(ordersStorage.addOrders(new ArrayList<>()));
    }

    @Test
    public void getOrders() {
        ordersStorage.addOrders(orders);
        assertTrue(ordersStorage.getOrders().contains(orders.get(0)));
        assertTrue(ordersStorage.getOrders().contains(orders.get(1)));
        assertTrue(ordersStorage.getOrders().contains(orders.get(2)));
    }
}
