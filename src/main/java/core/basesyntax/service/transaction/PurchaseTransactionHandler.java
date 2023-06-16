package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitInventoryManipulator;

public class PurchaseTransactionHandler extends TransactionHandler {
    public PurchaseTransactionHandler(FruitInventoryManipulator fruitInventoryManipulator) {
        super(fruitInventoryManipulator);
    }

    @Override
    public void handle(FruitTransaction transaction) {
        fruitInventoryManipulator.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
