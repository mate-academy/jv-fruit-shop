package core.basesyntax.operations;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void changeFruitQuantity(String fruit, int quantity) {
        Storage.reportData.put(fruit, quantity);
    }
}
