package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer storageFruitQuanity = Storage.fruitsStorage.get(fruitName);
        int transactionQuantity = fruitTransaction.getQuantity();
        if (storageFruitQuanity - transactionQuantity < 0) {
            throw new RuntimeException("No enough :" + fruitName);
        }
        Storage.fruitsStorage.put(fruitName, storageFruitQuanity - transactionQuantity);
    }
}
