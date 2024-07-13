package service;

import java.util.Map;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        String fruit = transaction.getFruit();
        int currentBalance = storage.getOrDefault(fruit, 0);
        int updatedBalance = currentBalance + transaction.getQuantity();
        if (updatedBalance < 0) {
            throw new RuntimeException("Negative balance for " + fruit + " - " + updatedBalance);
        }
        storage.put(fruit, updatedBalance);
    }
}
