package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private static final String INVALID_PURCHASE_QUANTITY = "Invalid purchase quantity: ";

    @Override
    public void process(FruitTransaction transaction) {
        Integer fruitQuantity = Storage.fruits.get(transaction.getFruitName());
        int purchaseQuantity = transaction.getQuantity();
        if (purchaseQuantity > 0 && purchaseQuantity <= fruitQuantity) {
            int updatedQuantity = fruitQuantity - purchaseQuantity;
            Storage.fruits.put(transaction.getFruitName(), updatedQuantity);
        } else {
            throw new IllegalArgumentException(INVALID_PURCHASE_QUANTITY + purchaseQuantity);
        }
    }
}
