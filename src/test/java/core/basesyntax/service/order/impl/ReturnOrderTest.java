package core.basesyntax.service.order.impl;

import core.basesyntax.Fruit;
import core.basesyntax.Order;
import core.basesyntax.Storage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class ReturnOrderTest {

    private Order orderBanana;
    private ReturnOrder returnOrder;

    @Before
    public void init() {
        returnOrder = new ReturnOrder();
        orderBanana = buildOrder("banana");
        Storage.fruits.clear();
    }

    @Test
    public void checkReturnOneFruitTest() {
        returnOrder.operation(orderBanana);
        Assert.assertEquals(buildFruitBanana(), Storage.fruits.get(0));
    }

    @Test
    public void checkReturnSameFruitsTest() {
        returnOrder.operation(orderBanana);
        returnOrder.operation(orderBanana);
        Assert.assertEquals(1, Storage.fruits.size());
    }

    @Test
    public void checkReturnDifferentFruitsTest() {
        returnOrder.operation(orderBanana);
        returnOrder.operation(buildOrder("orange"));
        Assert.assertEquals(2, Storage.fruits.size());
    }

    private Order buildOrder(String name) {
        LocalDate date = LocalDate.parse("2020-10-17");
        Order order = new Order();
        order.setType('r');
        order.setFruitName(name);
        order.setQuantity(200);
        order.setDate(date);
        return order;
    }

    private Fruit buildFruitBanana() {
        return new Fruit(200, "banana", orderBanana.getDate());
    }
}
