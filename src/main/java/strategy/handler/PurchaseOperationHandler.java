package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int prevQuantity = Storage.FRUITS.get(fruitTransaction.getFruit());
        if (prevQuantity < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Not enough " + fruitTransaction.getFruit()
                    + " for purchase!");
        }
        Storage.FRUITS.put(fruitTransaction.getFruit(), prevQuantity
                - fruitTransaction.getQuantity());
    }
}
