package handler;

import db.Storage;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.putOrChange(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
