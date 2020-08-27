package core.basesyntax.orderprocessing;

import core.basesyntax.entries.FruitPack;
import core.basesyntax.entries.Order;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersStorageTest {
    private static final FruitPack pack1 = new FruitPack("first", 15, LocalDate.now());
    private static final FruitPack pack2 = new FruitPack("second", 15, LocalDate.now());
    private static final FruitPack pack3 = new FruitPack("third", 15, LocalDate.now());
    private static final Order order1 = new Order(pack1, "s");
    private static final Order order2 = new Order(pack2, "b");
    private static final Order order3 = new Order(pack3, "r");
    private static final List<Order> orders = List.of(order1, order2, order3);
    private final OrdersStorage ordersStorage = new OrdersStorage();

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
