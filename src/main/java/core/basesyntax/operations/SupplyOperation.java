package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.OperationHandler;
import core.basesyntax.Storage;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
