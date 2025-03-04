package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int purchase = transaction.getQuantity();

        int current = Storage.storage.getOrDefault(fruit, 0);
        Storage.storage.put(fruit, current - purchase);
    }
}
