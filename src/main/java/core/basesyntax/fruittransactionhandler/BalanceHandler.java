package core.basesyntax.fruittransactionhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.getDataStorageMap()
                .put(fruitTransaction.getFruit(), 0);
        Storage.getDataStorageMap()
                .put(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
    }
}
