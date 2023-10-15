package fruit.shop.strategy;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Data is null");
        }
        int actual = Storage.DB.get(transaction.getFruit());
        int result = actual + transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("Quantity is < 0 " + result);
        }
        Storage.DB.put(transaction.getFruit(),result);
    }
}
