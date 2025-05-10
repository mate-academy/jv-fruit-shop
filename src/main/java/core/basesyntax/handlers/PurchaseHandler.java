package core.basesyntax.handlers;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction, Map<String, Integer> fruitStore) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Integer currentQuantity = fruitStore.get(fruit);
        if (currentQuantity == null || currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in the store");
        }
        fruitStore.merge(fruit, quantity, (oldQuantity, newQuantity) -> oldQuantity - newQuantity);
    }
}
