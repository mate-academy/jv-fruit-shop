package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int calculate(Fruit fruit) {
        return -fruit.getFruitQuantity();
    }
}
