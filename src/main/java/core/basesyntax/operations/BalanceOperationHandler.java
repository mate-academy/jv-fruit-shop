package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
