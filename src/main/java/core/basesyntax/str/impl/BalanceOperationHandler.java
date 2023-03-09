package core.basesyntax.str.impl;

import core.basesyntax.database.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.str.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        FruitStorage.fruit.put(transaction.getFruit(), transaction.getQuantity());
    }
}
