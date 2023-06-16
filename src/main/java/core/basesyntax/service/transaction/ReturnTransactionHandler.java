package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitInventoryManipulator;

public class ReturnTransactionHandler extends TransactionHandler {
    public ReturnTransactionHandler(FruitInventoryManipulator fruitInventoryManipulator) {
        super(fruitInventoryManipulator);
    }

    @Override
    public void handle(FruitTransaction transaction) {
        Integer existingAmount = fruitInventoryManipulator.getValue(transaction.getFruit());
        fruitInventoryManipulator.validateValue(existingAmount);
        fruitInventoryManipulator.add(transaction.getFruit(), transaction.getQuantity());
    }
}
