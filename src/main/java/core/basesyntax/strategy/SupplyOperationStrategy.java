package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.TransactionStorage;

public class SupplyOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitTransaction.setAmount(fruitTransaction.getAmount());
        if (TransactionStorage.transactionStorage.containsKey(fruitTransaction.getName())) {
            Integer currentAmount = TransactionStorage.transactionStorage
                    .get(fruitTransaction.getName());

            TransactionStorage.transactionStorage
                    .put(fruitTransaction.getName(), currentAmount + fruitTransaction.getAmount());
        } else {
            TransactionStorage.transactionStorage
                    .put(fruitTransaction.getName(), fruitTransaction.getAmount());
        }
    }
}
