package core.basesyntax.util;

import core.basesyntax.Order;
import core.basesyntax.service.order.OrderOperations;
import core.basesyntax.service.order.impl.BuyOrder;
import core.basesyntax.service.order.impl.ReturnOrder;
import core.basesyntax.service.order.impl.SupplyOrder;
import java.util.Map;
import java.util.Objects;

public class OrderUtils {

    private static final Map<Character, OrderOperations> OPERATIONS = Map.of(
            's', new SupplyOrder(),
            'b', new BuyOrder(),
            'r', new ReturnOrder());

    public static void processOrder(Order order) {
        OrderOperations orderOperations = OPERATIONS.get(order.getType());
        if (Objects.nonNull(orderOperations)) {
            orderOperations.operation(order);
        } else {
            throw new UnsupportedOperationException("Unknown operation");
        }
    }
}
