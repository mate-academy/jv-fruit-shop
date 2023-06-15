package strategy.operation;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldSum = Storage.fruits.get(fruitTransaction.getFruit());
        if (oldSum <= 0 || oldSum < fruitTransaction.getQuantity()) {
            throw new RuntimeException("The base quantity of fruit isn't correct " + oldSum);
        }
        Storage.fruits.put(fruitTransaction.getFruit(), oldSum - fruitTransaction.getQuantity());
    }
}
