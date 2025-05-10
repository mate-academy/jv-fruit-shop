package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationHandler {
    public void handle(FruitTransaction transaction) {
        Storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
