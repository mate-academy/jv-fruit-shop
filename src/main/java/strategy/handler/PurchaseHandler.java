package strategy.handler;

import db.Storage;
import model.FruitTransaction;
import strategy.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int realQuantity = Storage.fruits.get(transaction.getFruit());
        int quantityToPurchase =
                Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity();
        if (quantityToPurchase < 0) {
            throw new RuntimeException("Storage doesn't have enough products to sell");
        } else {
            Storage.fruits.put(transaction.getFruit(), quantityToPurchase);
        }
    }
}
