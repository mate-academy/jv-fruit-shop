package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;

public class BalanceHandler implements OperationHandler {
    @Override
    public int calculate(Fruit fruit) {
        return fruit.getFruitQuantity();
    }
}
