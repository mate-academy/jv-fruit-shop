package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int makeOperation(FruitTransaction transaction, int storedAmount) {
        if (storedAmount - transaction.getQuantity() > 0) {
            return storedAmount - transaction.getQuantity();
        }
        throw new RuntimeException("The amount after purchase is less than 0");
    }
}
