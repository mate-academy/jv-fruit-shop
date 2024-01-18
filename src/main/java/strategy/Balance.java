package strategy;

import db.Storage;
import model.FruitTransaction;

public class Balance implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
