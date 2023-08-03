package core.basesyntax.operation;

import core.basesyntax.db.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handleOperation(String fruit, int quantity) {
        Storage.reportData.put(fruit, quantity);
    }
}
