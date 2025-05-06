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

        if (current < purchase) {
            throw new RuntimeException("Not enough " + fruit + " in the storage! "
                   + "Available: " + current + " Need: " + purchase);
        } else if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException("There is no such fruit in the storage!: " + fruit);
        }
        Storage.storage.put(fruit, current - purchase);
    }
}
