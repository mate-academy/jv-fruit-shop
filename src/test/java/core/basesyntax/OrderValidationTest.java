package core.basesyntax;

import org.junit.Test;

public class OrderValidationTest {
    private OrderValidation orderValidation = new OrderValidation();

    @Test(expected = RuntimeException.class)
    public void checkInputOrderWithNotEnoughInformation() {
        String[] order = new String[3];
        orderValidation.toCheckOrder(order);
    }

    @Test(expected = RuntimeException.class)
    public void checkInputOrderWithWrongOperation() {
        String[] order = new String[4];
        order[0] = "g";
        orderValidation.toCheckOrder(order);
    }
}
