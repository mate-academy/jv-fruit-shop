package core.basesyntax.util;

import core.basesyntax.Fruit;
import core.basesyntax.Order;
import core.basesyntax.Storage;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class OrderUtilsTest {

    @Before
    public void clearStorage() {
        Storage.fruits.clear();
    }

    @Test
    public void checkSupplyTest() {
        OrderUtils.processOrder(buildOrder('s'));
        assertEquals(buildFruit(200), Storage.fruits.get(0));
    }

    @Test
    public void checkReturnTest() {
        OrderUtils.processOrder(buildOrder('r'));
        assertEquals(buildFruit(200), Storage.fruits.get(0));
    }

    @Test
    public void checkBuyTest() {
        Storage.fruits.add(buildFruit(400));
        OrderUtils.processOrder(buildOrder('b'));
        assertEquals(200, Storage.fruits.get(0).getQuantity());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void checkIncorrectOrderTypeTest() {
        OrderUtils.processOrder(buildOrder('a'));
    }

    private Order buildOrder(char type) {
        LocalDate date = LocalDate.parse("2020-10-17");
        Order order = new Order();
        order.setType(type);
        order.setFruitName("banana");
        order.setQuantity(200);
        order.setDate(date);
        return order;
    }

    private Fruit buildFruit(int quantity) {
        return new Fruit(quantity, "banana", LocalDate.parse("2020-10-17"));
    }
}
