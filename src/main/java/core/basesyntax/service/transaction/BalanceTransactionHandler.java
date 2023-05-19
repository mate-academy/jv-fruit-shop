package core.basesyntax.service.transaction;

import core.basesyntax.InvalidTransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitInventoryManipulator;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer existingAmount = FruitInventoryManipulator.getValue(transaction.getFruit());
        if (existingAmount != null) {
            throw new InvalidTransactionException(
                    "Balance action can't be performed when fruit already exists");
        }
        FruitInventoryManipulator.add(transaction.getFruit(), transaction.getQuantity());
    }
}
