package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public int calculate(FruitTransaction fruit) {
        return fruit.getFruitQuantity();
    }
}
