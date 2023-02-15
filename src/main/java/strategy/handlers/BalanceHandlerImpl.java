package strategy.handlers;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruitName();
        int fruitTransactionQuantity = fruitTransaction.getQuantity();
        Storage.fruitsStorage.put(fruitName, fruitTransactionQuantity);
    }
}
