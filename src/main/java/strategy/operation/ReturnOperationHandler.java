package strategy.operation;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldSum = Storage.fruits.get(fruitTransaction.getFruit());
        Storage.fruits.put(fruitTransaction.getFruit(), oldSum + fruitTransaction.getQuantity());
    }
}
