package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void doOperation(Fruit fruit, int quantity) {
        fruit.setAmount(fruit.getAmount() - quantity);
    }
}
