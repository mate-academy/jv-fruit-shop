package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void changeFruitQuantity(String fruit, int quantity) {
        Storage.reportData.put(fruit,
                (Storage.reportData.get(fruit) == null ? 0
                        : Storage.reportData.get(fruit))
                        + quantity);
    }
}
