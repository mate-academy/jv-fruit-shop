package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.FRUITS.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
