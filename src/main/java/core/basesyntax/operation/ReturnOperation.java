package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.storage.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
