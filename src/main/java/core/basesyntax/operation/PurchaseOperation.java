package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.NoSuchElementException;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int fruitsToBuy = fruitTransaction.getQuantity();
        Storage.storage.merge(fruit, fruitsToBuy, (prevQuantity, newQuantity) -> {
            if (newQuantity > prevQuantity) {
                throw new NoSuchElementException("Not enough fruit for purchase. You can purchase max: " + prevQuantity);
            }
            return prevQuantity - newQuantity;
        });
    }
}
