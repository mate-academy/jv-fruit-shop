package core.basesyntax.operation;

import core.basesyntax.db.Storage;

public class BalanceHandler implements OperationHandler {

    @Override
    public void operateStorage(String fruitType, Integer quantity) {
        Storage.storageContents.put(fruitType,quantity);
    }
}
