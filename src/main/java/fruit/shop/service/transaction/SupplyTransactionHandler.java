package fruit.shop.service.transaction;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void execute(FruitTransaction transaction) {
        Integer currentQuantity = Storage.get(transaction.getFruit());
        currentQuantity += transaction.getQuantity();
        Storage.put(transaction.getFruit(), currentQuantity);
    }
}
