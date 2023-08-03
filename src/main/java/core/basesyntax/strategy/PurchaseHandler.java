package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.IllegalQuantityException;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int purchaseQuantity = fruitTransaction.getQuantity();
        int currentQuantity = Storage.fruitStorage.get(fruitName);
        int newQuantity = currentQuantity - purchaseQuantity;

        if (purchaseQuantity < 0) {
            throw new IllegalQuantityException("Transaction \"purchase\" can`t be negative value");
        }
        if (newQuantity < 0) {
            throw new IllegalQuantityException(
                    "Result of transaction \"purchase\" can`t be negative value");
        }

        Storage.fruitStorage.put(fruitName, newQuantity);

    }
}
