package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public class Transaction {
    private Map<String, Integer> fruits;

    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            String fruit = transaction.fruit();
            int quantity = transaction.quantity();
            switch (transaction.operation()) {
                case BALANCE:
                case SUPPLY, RETURN:
                    fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
                    break;
                case PURCHASE:
                    fruits.put(fruit, fruits.getOrDefault(fruit, 0) - quantity);
                    break;
                default:
            }
        }
    }
}
