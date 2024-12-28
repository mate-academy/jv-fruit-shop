package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction fruitTransaction, Integer quantity) {
        fruitTransaction.setQuantity(fruitTransaction.getQuantity() + quantity);
    }
}
