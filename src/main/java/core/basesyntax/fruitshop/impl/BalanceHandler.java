package core.basesyntax.fruitshop.impl;

import core.basesyntax.fruitshop.db.Storage;
import core.basesyntax.fruitshop.model.FruitTransaction;
import core.basesyntax.fruitshop.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getInstance().getFruitStorage().put(transaction.getFruit(),
                transaction.getQuantity());
    }
}
