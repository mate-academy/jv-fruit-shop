package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class SupplyHandler implements OperationHandler {

    @Override
    public void execute(String fruitName, int quantity) {
        Storage.storage.put(fruitName, Storage.storage.get(fruitName) + quantity);
    }
}
