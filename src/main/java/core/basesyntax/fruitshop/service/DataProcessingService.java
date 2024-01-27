package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessingService {
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitInventory = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            int currentQuantity = fruitInventory.getOrDefault(fruit, 0);

            switch (transaction.getOperation()) {
                case PURCHASE -> fruitInventory.put(fruit, currentQuantity - quantity);
                case BALANCE, SUPPLY, RETURN -> fruitInventory
                        .put(fruit, currentQuantity + quantity);
                default -> throw new IllegalStateException("Unexpected value: "
                        + transaction.getOperation());
            }
        }
        return fruitInventory;
    }
}
