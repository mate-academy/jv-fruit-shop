package core.basesyntax.service.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void transaction(FruitTransaction fruitTransaction, Storage storage) {
        Map<String, Integer> fruits = storage.getFruits();
        String fruitName = fruitTransaction.getFruitName();
        int currentQuantity = fruits.getOrDefault(fruitName, 0);
        int newQuantity = currentQuantity - fruitTransaction.getTransactionQuantity();

        if (newQuantity < 0) {
            throw new IllegalArgumentException("Insufficient quantity of "
                    + fruitName
                    + ". Cannot perform transaction that results in negative quantity.");
        }

        fruits.replace(fruitName, newQuantity);
    }
}
