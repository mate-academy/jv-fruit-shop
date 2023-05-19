package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitInventoryManipulator;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        FruitInventoryManipulator.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
