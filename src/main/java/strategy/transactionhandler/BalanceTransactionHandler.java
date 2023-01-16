package strategy.transactionhandler;

import db.Storage;
import service.FruitTransaction;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
