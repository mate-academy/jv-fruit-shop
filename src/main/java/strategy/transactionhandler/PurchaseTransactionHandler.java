package strategy.transactionhandler;

import db.Storage;
import service.FruitTransaction;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public int operate(FruitTransaction fruitTransaction) {
        int currentFruitAmount = Storage.fruits.get(fruitTransaction.getGetFruit());
        int newFruitValue = currentFruitAmount - fruitTransaction.getGetAmount();
        if (newFruitValue < 0) {
            System.out.println("I'm sorry, but we do not have the requested fruit amount :(");
            newFruitValue = 0;
        }
        Storage.fruits.put(fruitTransaction.getGetFruit(), newFruitValue);
        return newFruitValue;
    }
}
