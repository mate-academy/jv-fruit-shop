package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction can`t be null");
        }

        String fruitName = fruitTransaction.getFruit();
        int purchaseQuantity = fruitTransaction.getQuantity();
        int currentQuantity = Storage.fruitStorage.get(fruitName);
        int newQuantity = currentQuantity - purchaseQuantity;

        if (purchaseQuantity < 0 ) {
            throw new RuntimeException("Transaction \"purchase\" can`t be negative value");
        }
        if (newQuantity < 0) {
            throw new RuntimeException("Result of transaction \"purchase\" can`t be negative value");
        }

        Storage.fruitStorage.put(fruitName, newQuantity);

    }
}
