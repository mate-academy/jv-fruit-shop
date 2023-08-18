package core.basesyntax.operation;

import core.basesyntax.db.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        Storage.reportData.put(fruit,
                (Storage.reportData.get(fruit) == null ? 0
                        : Storage.reportData.get(fruit))
                        + quantity);
    }
}
