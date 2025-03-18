package core.basesyntax.operationhandlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransactionImpl;

public class ReturnOperationHandler implements OperationHandler {
    public void apply(FruitTransactionImpl transaction) {
        Storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
