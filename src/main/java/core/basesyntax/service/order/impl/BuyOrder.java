package core.basesyntax.service.order.impl;

import core.basesyntax.Order;
import core.basesyntax.Storage;
import core.basesyntax.service.order.OrderOperations;
import java.util.Objects;

public class BuyOrder implements OrderOperations {

    @Override
    public void operation(Order order) {
        Storage.fruits.stream()
                .filter(x -> Objects.equals(x.getName(), order.getFruitName())
                        && (x.getExpirationDate().isAfter(order.getDate())
                        || x.getExpirationDate().isEqual(order.getDate()))
                        && x.getQuantity() >= order.getQuantity())
                .findFirst()
                .ifPresent(x -> x.setQuantity(x.getQuantity() - order.getQuantity()));
    }
}
