package core.basesyntax.service.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void operationTransaction(FruitTransaction transaction) {
        int newQuantityFruits = Storage.storage.get(transaction.getFruit())
                - transaction.getQuantity();
        if (newQuantityFruits >= 0) {
            Storage.storage.put(transaction.getFruit(), newQuantityFruits);
        } else {
            throw new RuntimeException("Not enough fruit");
        }
    }
}
