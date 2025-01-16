package core.basesyntax.strategy.operation;

import core.basesyntax.data.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
