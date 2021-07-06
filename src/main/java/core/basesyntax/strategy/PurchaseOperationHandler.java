package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        int oldQuantity = Storage.data.get(transaction.getFruitName());
        int newQuantity = oldQuantity - transaction.getQuality();
        Storage.data.put(transaction.getFruitName(), newQuantity);
        return newQuantity;
    }
}
