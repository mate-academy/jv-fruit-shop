package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;


public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void execute(FruitTransaction transaction) {
        Storage.fruitTransactions.put(transaction.getName(), transaction);
    }
}
