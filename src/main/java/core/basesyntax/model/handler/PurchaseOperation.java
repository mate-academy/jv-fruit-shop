package core.basesyntax.model.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction transaction) {
        int currentBalance = storage.getOrDefault(transaction.getFruit(), 0);
        int newBalance = currentBalance - transaction.getQuantity();

        if (newBalance < 0) {
            throw new RuntimeException("Insufficient balance for fruit: " + transaction.getFruit());
        }

        storage.put(transaction.getFruit(), newBalance);
    }
}
