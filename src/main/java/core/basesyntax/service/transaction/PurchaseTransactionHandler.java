package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
