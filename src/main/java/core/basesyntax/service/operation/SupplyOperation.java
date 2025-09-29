package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.updateFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
