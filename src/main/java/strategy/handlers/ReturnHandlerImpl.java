package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        Integer storageFruitQuanity = Storage.fruitsStorage.get(fruitName);
        int transactionQuantity = fruitTransaction.getQuantity();
        Storage.fruitsStorage.replace(fruitName, storageFruitQuanity + transactionQuantity);
    }
}
