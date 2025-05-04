package fruitshop.strategy;

import fruitshop.db.Storage;
import fruitshop.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int current = Storage.get(fruit);
        int result = current - transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("Not enough " + fruit + " in storage. Trying to purchase "
                    + transaction.getQuantity());
        }
        Storage.put(fruit, result);
    }
}
