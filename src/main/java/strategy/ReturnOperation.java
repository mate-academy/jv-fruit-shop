package strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.increaseQuantity(transaction.getFruit(), transaction.getQuantity());
    }
}
