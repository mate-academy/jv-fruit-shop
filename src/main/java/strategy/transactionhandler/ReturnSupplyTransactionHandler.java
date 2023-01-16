package strategy.transactionhandler;

import db.Storage;
import service.FruitTransaction;

public class ReturnSupplyTransactionHandler implements TransactionHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int currentFruitAmount = Storage.fruits.get(fruitTransaction.getFruit());
        int newFruitAmount = currentFruitAmount + fruitTransaction.getQuantity();

        Storage.fruits.put(fruitTransaction.getFruit(),newFruitAmount);
    }
}
