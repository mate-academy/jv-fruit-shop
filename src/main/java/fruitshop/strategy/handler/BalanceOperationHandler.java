package fruitshop.strategy.handler;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        Storage.fruits.put(transaction.getFruit(), transaction.getQuantity());
    }
}
