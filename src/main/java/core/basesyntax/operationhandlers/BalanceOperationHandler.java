package core.basesyntax.operationhandlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
