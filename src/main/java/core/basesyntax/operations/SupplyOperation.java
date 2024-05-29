package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;
import core.basesyntax.dao.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
