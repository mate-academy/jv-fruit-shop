package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.fruits.merge(transaction.getFruit(), -transaction.getQuantity(), Integer::sum);
    }
}
