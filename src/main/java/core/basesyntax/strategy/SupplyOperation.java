package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;

public class SupplyOperation implements OperationHandler {
    public void apply(FruitTransaction transaction) {
        Storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
