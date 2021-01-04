package core.basesyntax.service.order.impl;

import core.basesyntax.Fruit;
import core.basesyntax.Order;
import core.basesyntax.Storage;
import core.basesyntax.service.order.OrderOperations;

public class SupplyOrder implements OrderOperations {

    @Override
    public void operation(Order order) {
        for (Fruit fruit : Storage.fruits) {
            if (fruit.getName().equals(order.getFruitName())
                    && fruit.getExpirationDate().isEqual(order.getDate())) {
                fruit.setQuantity(fruit.getQuantity() + order.getQuantity());
                return;
            }
        }
        Storage.fruits.add(new Fruit(order.getQuantity(), order.getFruitName(), order.getDate()));
    }
}
