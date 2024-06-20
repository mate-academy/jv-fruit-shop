package core.basesyntax.stategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Integer fruitQuantity = Storage.fruits.get(transaction.getFruitName());
        int purchaseQuantity = transaction.getQuantity();
        if (purchaseQuantity > 0 && purchaseQuantity <= fruitQuantity) {
            int updateQuantity = fruitQuantity - purchaseQuantity;
            Storage.fruits.put(transaction.getFruitName(), updateQuantity);
        } else {
            throw new IllegalArgumentException("Invalid quantity: " + purchaseQuantity);
        }
    }
}
