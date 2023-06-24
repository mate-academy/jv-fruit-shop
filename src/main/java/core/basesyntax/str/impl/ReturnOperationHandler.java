package core.basesyntax.str.impl;

import core.basesyntax.database.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.str.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int oldQuantity = FruitStorage.fruit.get(transaction.getFruit());
        FruitStorage.fruit.put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
