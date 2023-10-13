package fruit.shop.strategy;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Data is null");
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity is < 0 " + transaction.getQuantity());
        }
        Integer quantity = Storage.DB.get(transaction.getFruit());
        Integer result = quantity + transaction.getQuantity();
        Storage.DB.put(transaction.getFruit(),result);
    }
}
