package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction fruitTransaction, Integer quantity) {
        fruitTransaction.setQuantity(fruitTransaction.getQuantity() + quantity);
    }
}
