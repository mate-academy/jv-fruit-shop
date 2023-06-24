package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void evaluateTransaction(FruitTransaction transaction) {
        if (!Storage.storage.containsKey(transaction.getFruit())) {
            throw new RuntimeException("There no such fruits at the storage yet!");
        }
        Storage.storage.put(transaction.getFruit(),
                Storage.storage.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
