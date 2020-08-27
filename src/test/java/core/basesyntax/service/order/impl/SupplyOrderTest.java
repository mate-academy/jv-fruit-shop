package core.basesyntax.service.order.impl;

import core.basesyntax.Fruit;
import core.basesyntax.Order;
import core.basesyntax.Storage;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class SupplyOrderTest {

    private Order orderBanana;
    private SupplyOrder supply;

    @Before
    public void init() {
        supply = new SupplyOrder();
        orderBanana = buildOrder("banana");
        Storage.fruits.clear();
    }

    @Test
    public void checkSupplyOneFruitTest() {
        supply.operation(orderBanana);
        assertEquals(buildFruitBanana(), Storage.fruits.get(0));
    }

    @Test
    public void checkSupplySameFruitsTest() {
        supply.operation(orderBanana);
        supply.operation(orderBanana);
        assertEquals(1, Storage.fruits.size());
    }

    @Test
    public void checkSupplyDifferentFruitsTest() {
        supply.operation(orderBanana);
        supply.operation(buildOrder("orange"));
        assertEquals(2, Storage.fruits.size());
    }

    private Order buildOrder(String name) {
        LocalDate date = LocalDate.parse("2020-10-17");
        Order order = new Order();
        order.setType('s');
        order.setFruitName(name);
        order.setQuantity(200);
        order.setDate(date);
        return order;
    }

    private Fruit buildFruitBanana() {
        return new Fruit(200, "banana", orderBanana.getDate());
    }
}
