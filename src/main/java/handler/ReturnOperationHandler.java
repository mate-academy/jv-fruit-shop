package handler;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.putOrChange(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
