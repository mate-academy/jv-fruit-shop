package core.basesyntax.operations;

import core.basesyntax.model.Fruit;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public long perform(Fruit fruit, long operationQuantity) {
        return fruit.getQuantity() + operationQuantity;
    }
}
