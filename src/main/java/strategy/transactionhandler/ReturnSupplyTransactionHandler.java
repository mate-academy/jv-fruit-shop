package strategy.transactionhandler;

import db.Storage;
import service.FruitTransaction;

public class ReturnSupplyTransactionHandler implements TransactionHandler {
    @Override
    public int operate(FruitTransaction fruitTransaction) {
        int currentFruitAmount = Storage.fruits.get(fruitTransaction.getGetFruit());
        int newFruitAmount = currentFruitAmount + fruitTransaction.getGetAmount();

        Storage.fruits.put(fruitTransaction.getGetFruit(),newFruitAmount);

        return newFruitAmount;
    }
}
