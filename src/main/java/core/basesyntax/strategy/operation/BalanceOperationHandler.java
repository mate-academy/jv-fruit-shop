package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitOperation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getQuantityFromStore(FruitOperation fruitOperation, int value) {
        fruitOperation.setQuantity(value);
        return value;
    }
}
