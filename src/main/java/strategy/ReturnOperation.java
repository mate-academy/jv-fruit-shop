package strategy;

import db.Storage;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        int quantity = Storage.fruits.get(fruitTransaction.getFruit());
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity() + quantity);
    }
}
