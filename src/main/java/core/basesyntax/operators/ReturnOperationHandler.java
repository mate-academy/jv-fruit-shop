package core.basesyntax.operators;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(String product, int amount) {
        int productAmount = Storage.storage.get(product) + amount;
        Storage.storage.replace(product, productAmount);
    }
}
