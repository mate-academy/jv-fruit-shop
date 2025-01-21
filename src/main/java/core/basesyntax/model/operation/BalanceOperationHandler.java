package core.basesyntax.model.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    //Adds amount of fruit to storage. if contains fruit - changes a value
    @Override
    public void handle(FruitTransaction transaction) {
        storage.getInventory().put(transaction.getFruit(), transaction.getQuantity());
    }
}
