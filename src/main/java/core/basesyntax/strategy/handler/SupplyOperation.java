package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void execute(FruitTransaction transaction) {
        FruitTransaction current = Storage.fruitTransactions.get(transaction.getName());
        current.setQuantity(current.getQuantity() + transaction.getQuantity());
    }
}
