package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer existingAmount = getValue(transaction.getFruit());
        validateValue(existingAmount);
        add(transaction.getFruit(), transaction.getQuantity());
    }
}
