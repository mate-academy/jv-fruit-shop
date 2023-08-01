package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Fruit completeOperation(Fruit fruit) {
        return fruit;
    }
}
