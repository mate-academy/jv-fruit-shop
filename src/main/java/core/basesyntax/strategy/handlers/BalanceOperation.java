package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.handlers.FruitTransactionException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (Storage.fruits.containsKey(transaction.getFruit())) {
            throw new FruitTransactionException("Fruit " + transaction.getFruit()
                    + " already in storage");
        }
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
