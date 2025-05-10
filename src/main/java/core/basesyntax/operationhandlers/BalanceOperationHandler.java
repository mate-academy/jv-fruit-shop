package core.basesyntax.operationhandlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransactionImpl;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransactionImpl transaction) {
        Storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
