package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int realQuantity = Storage.fruits.get(transaction.getFruit());
        int quantityAfterPurchase = realQuantity - transaction.getQuantity();
        if (quantityAfterPurchase < 0) {
            throw new RuntimeException("Storage doesn't have enough products to sell");
        }
        Storage.fruits.put(transaction.getFruit(), quantityAfterPurchase);
        }
    }
}
