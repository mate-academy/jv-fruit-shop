package fruitshop.strategy.handler;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction transaction) {
        int oldQuantity = Storage.fruits.get(transaction.getFruit());
        Storage.fruits.put(transaction.getFruit(), oldQuantity
                    + transaction.getQuantity());
    }
}
