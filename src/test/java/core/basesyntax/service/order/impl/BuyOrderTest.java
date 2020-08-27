package core.basesyntax.service.order.impl;

import core.basesyntax.Fruit;
import core.basesyntax.Order;
import core.basesyntax.Storage;
import org.junit.Before;
import org.junit.Test;;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class BuyOrderTest {

    private BuyOrder buy;

    @Before
    public void init() {
        buy = new BuyOrder();
        Storage.fruits.clear();
    }

    @Test
    public void checkBuyOneFruitTest() {
        addFruitToStorage("2020-08-27");
        buy.operation(buildOrder(70));
        assertEquals(130, Storage.fruits.get(0).getQuantity());
    }

    @Test
    public void checkBuyFruitAfterExpirationDateTest() {
        addFruitToStorage("2020-08-24");
        buy.operation(buildOrder(70));
        assertEquals(200, Storage.fruits.get(0).getQuantity());
    }

    @Test
    public void checkBuyFruitWithExceedingQuantityTest() {
        addFruitToStorage("2020-08-27");
        buy.operation(buildOrder(250));
        assertEquals(200, Storage.fruits.get(0).getQuantity());
    }

    private Order buildOrder(int quantity) {
        LocalDate date = LocalDate.parse("2020-08-27");
        Order order = new Order();
        order.setType('b');
        order.setFruitName("banana");
        order.setQuantity(quantity);
        order.setDate(date);
        return order;
    }

    private void addFruitToStorage(String date) {
        Storage.fruits.add(new Fruit(200, "banana", LocalDate.parse(date)));
    }
}
