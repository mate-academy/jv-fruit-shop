package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int newQuantity = storage.getFruits()
                .get(transaction.getFruit()) - transaction.getQuantity();
        if (newQuantity >= 0) {
            storage.getFruits().put(transaction.getFruit(), newQuantity);
        } else {
            throw new RuntimeException("Fruit quantity does not become negative");
        }
    }
}
