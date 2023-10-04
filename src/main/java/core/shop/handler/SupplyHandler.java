package core.shop.handler;

import core.shop.db.Storage;
import core.shop.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void operation(FruitTransaction transaction) {
        int currentValue = Storage.fruits.get(transaction.getFruitName());
        Storage.fruits.put(transaction.getFruitName(), currentValue + transaction.getQuantity());
    }
}
