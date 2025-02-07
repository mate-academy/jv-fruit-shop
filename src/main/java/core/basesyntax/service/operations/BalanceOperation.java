package core.basesyntax.service.operations;

import core.basesyntax.infrastructure.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void run(FruitTransaction fruitTransaction) {
        Storage.STORAGE.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
