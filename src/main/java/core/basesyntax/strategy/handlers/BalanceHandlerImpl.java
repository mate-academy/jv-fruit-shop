package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
    }
}
