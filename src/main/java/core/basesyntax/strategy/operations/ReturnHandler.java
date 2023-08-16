package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;

public class ReturnHandler implements OperationHandler {
    @Override
    public void operateStorage(String fruitType, Integer quantity) {
        Storage.storageContents.put(fruitType,Storage.storageContents.get(fruitType) + quantity);
    }
}
