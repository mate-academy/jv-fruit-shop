package core.basesyntax.service.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction transaction) {
        int newQuantityFruits = Storage.storage.get(transaction.getFruit())
                + transaction.getQuantity();
        Storage.storage.put(transaction.getFruit(), newQuantityFruits);
    }
}
