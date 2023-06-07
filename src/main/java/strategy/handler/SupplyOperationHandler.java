package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int prevQuantity = Storage.FRUITS.get(fruitTransaction.getFruit());
        Storage.FRUITS.put(fruitTransaction.getFruit(), prevQuantity
                + fruitTransaction.getQuantity());
    }
}
