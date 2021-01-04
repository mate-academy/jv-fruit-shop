package core.basesyntax.service.order.impl;

import core.basesyntax.Order;
import core.basesyntax.service.order.OrderOperations;

public class ReturnOrder implements OrderOperations {

    @Override
    public void operation(Order order) {
        new SupplyOrder().operation(order);
    }
}
