package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
