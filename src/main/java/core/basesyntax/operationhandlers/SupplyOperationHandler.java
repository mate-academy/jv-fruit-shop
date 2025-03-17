package core.basesyntax.operationhandlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    public void apply(FruitTransaction transaction) {
        Storage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
