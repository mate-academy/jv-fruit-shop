package strategy.transactionhandler;

import db.Storage;
import service.FruitTransaction;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public int operate(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getGetFruit(), fruitTransaction.getGetAmount());
        return fruitTransaction.getGetAmount();
    }
}
