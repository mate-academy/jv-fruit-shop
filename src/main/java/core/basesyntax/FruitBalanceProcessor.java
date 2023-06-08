package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitBalanceProcessor {
    private static final int DEFAULT_AMOUNT = 0;

    public Map<String, Integer> calculateFruitBalance(List<FruitTransaction> transactions) {
        Map<String, Integer> balance = new HashMap<>();

        for (FruitTransaction transaction : transactions) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();

            switch (transaction.getOperation()) {
                case BALANCE:
                case SUPPLY:
                    balance.put(fruit, balance.getOrDefault(fruit, DEFAULT_AMOUNT) + quantity);
                    break;
                case PURCHASE:
                case RETURN:
                    balance.put(fruit, balance.getOrDefault(fruit, DEFAULT_AMOUNT) - quantity);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operation: "
                            + transaction.getOperation());
            }
        }

        return balance;
    }
}
