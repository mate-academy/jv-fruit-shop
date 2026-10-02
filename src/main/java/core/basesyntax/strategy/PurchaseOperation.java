package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        if (fruit.getQuantity() >= quantity) {
            fruit.setQuantity(fruit.getQuantity() - quantity);
        } else {
            throw new RuntimeException("The quantity in the store cannot be negative");
        }
    }
}
