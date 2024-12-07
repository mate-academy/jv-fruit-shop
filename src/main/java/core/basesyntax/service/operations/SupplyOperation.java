package core.basesyntax.service.operations;

import core.basesyntax.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void doOperation(FruitTransaction fruitTransaction, Integer quantity) {
        fruitTransaction.setQuantity(fruitTransaction.getQuantity() + quantity);
    }
}
