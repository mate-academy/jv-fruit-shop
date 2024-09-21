package core.basesyntax.operations;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        int currentQuantity = storage.getOrDefault(transaction.getFruit(), 0);
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Insufficient stock for purchase of "
                    + transaction.getFruit());
        }
        storage.put(transaction.getFruit(), newQuantity);
    }
}

