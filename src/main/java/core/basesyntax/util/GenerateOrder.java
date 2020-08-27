package core.basesyntax.util;

import core.basesyntax.order.Order;

public class GenerateOrder {
    public Order newOrder(String[] line) {
        String typeOfOperation = line[0];
        String typeOfFruit = line[1];
        int quantity = Integer.parseInt(line[2]);
        return new Order(typeOfOperation, typeOfFruit, quantity);
    }
}
