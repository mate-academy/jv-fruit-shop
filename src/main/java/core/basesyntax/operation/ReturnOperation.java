package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.returnFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
