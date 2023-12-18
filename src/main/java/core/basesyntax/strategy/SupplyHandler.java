package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public class SupplyHandler implements OperationHandler {
    @Override
    public int calculate(Fruit fruit) {
        return fruit.getFruitQuantity();
    }
}
