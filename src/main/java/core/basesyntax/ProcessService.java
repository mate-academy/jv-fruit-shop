package core.basesyntax;

import java.util.*;

public class ProcessService {
    public static Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitStock = new HashMap<>();

        for (FruitTransaction transaction : transactions) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            int currentQuantity = fruitStock.getOrDefault(fruit, 0);

            if (transaction.getOperation() == FruitTransaction.Operation.BALANCE ||
                    transaction.getOperation() == FruitTransaction.Operation.SUPPLY) {
                fruitStock.put(fruit, currentQuantity + quantity);
            } else if (transaction.getOperation() == FruitTransaction.Operation.PURCHASE ||
                    transaction.getOperation() == FruitTransaction.Operation.RETURN) {
                fruitStock.put(fruit, currentQuantity - quantity);
            }
        }

        return fruitStock;
    }
}
