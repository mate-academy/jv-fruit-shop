package core.basesyntax.strategy.operation;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.model.FruitTransaction;

public class ReturnTypeHandler implements OperationHandlers {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Integer currentQuantity = storage.get(transaction.getFruit());
        storage.put(transaction.getFruit(),currentQuantity
                + transaction.getQuantity());
    }
}
