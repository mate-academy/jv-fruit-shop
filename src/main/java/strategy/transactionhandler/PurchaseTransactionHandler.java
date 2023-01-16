package strategy.transactionhandler;

import db.Storage;
import service.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int currentFruitAmount = Storage.fruits.get(fruitTransaction.getFruit());
        int newFruitValue = currentFruitAmount - fruitTransaction.getQuantity();
        if (newFruitValue < 0) {
            newFruitValue = 0;
            throw new
                    RuntimeException("I'm sorry, but we do not have the requested fruit amount :(");
        }
        Storage.fruits.put(fruitTransaction.getFruit(), newFruitValue);
    }
}
