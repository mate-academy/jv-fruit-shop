package core.basesyntax.strategy.impl;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, ShopStorage storage) {
        storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
