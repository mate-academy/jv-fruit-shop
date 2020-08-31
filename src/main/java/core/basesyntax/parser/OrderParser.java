package core.basesyntax.parser;

import core.basesyntax.model.Order;

public class OrderParser implements ParseOperation {
    public Order parseNewOrder(String row) {
        String[] line = row.split(",");
        String typeOfOperation = line[0];
        String typeOfFruit = line[1];
        int quantity = Integer.parseInt(line[2]);
        if (line.length != 4) {
            throw new RuntimeException("Wrong argument format!");
        }
        return new Order(typeOfOperation, typeOfFruit, quantity);
    }
}
