package core.basesyntax.service.transaction;

import core.basesyntax.InvalidTransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitInventoryManipulator;

public class BalanceTransactionHandler extends TransactionHandler {
    public BalanceTransactionHandler(FruitInventoryManipulator fruitInventoryManipulator) {
        super(fruitInventoryManipulator);
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Integer existingAmount = fruitInventoryManipulator.getValue(transaction.getFruit());
        if (existingAmount != null) {
            throw new InvalidTransactionException(
                    "Balance action can't be performed when fruit already exists");
        }
        fruitInventoryManipulator.add(transaction.getFruit(), transaction.getQuantity());
    }
}
