package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class ReturnOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.returnFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
