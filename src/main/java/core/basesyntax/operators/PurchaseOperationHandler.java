package core.basesyntax.operators;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(String product, int amount) {
        int productAmount = Storage.storage.get(product);
        if (productAmount < amount) {
            throw new RuntimeException("Not enough products");
        } else if (productAmount == amount) {
            Storage.storage.remove(product);
        } else {
            Storage.storage.replace(product, productAmount - amount);
        }
    }
}
