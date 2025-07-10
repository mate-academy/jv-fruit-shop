package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;

public class BalanceOperation implements OperationHandler {

    @Override
    public void doOperation(Fruit fruit, int quantity) {
        fruit.setAmount(quantity);
    }
}
