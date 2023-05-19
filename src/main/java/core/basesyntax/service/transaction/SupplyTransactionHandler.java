package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitInventoryManipulator;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer existingAmount = FruitInventoryManipulator.getValue(transaction.getFruit());
        FruitInventoryManipulator.validateValue(existingAmount);
        FruitInventoryManipulator.add(transaction.getFruit(), transaction.getQuantity());
    }
}
