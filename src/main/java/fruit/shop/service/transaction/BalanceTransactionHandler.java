package fruit.shop.service.transaction;

import fruit.shop.db.Storage;
import fruit.shop.model.FruitTransaction;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void execute(FruitTransaction transaction) {
        Storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
