package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        fruit.setQuantity(fruit.getQuantity() + quantity);
    }
}
