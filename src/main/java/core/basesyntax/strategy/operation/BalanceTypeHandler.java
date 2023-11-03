package core.basesyntax.strategy.operation;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.model.FruitTransaction;

public class BalanceTypeHandler implements OperationHandlers {

    @Override
    public void handleTransaction(FruitTransaction transaction) {
        storage.put(transaction.getFruit(),transaction.getQuantity());
    }
}
