package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TrabnsactionProcessor {

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Transaction is null");
        }
        Map<String, Integer> fruits = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            String fruit = transaction.fruit();
            int quantity = transaction.quantity();
            switch (transaction.operation()) {
                case BALANCE:
                    fruits.put(fruit, quantity);
                    break;
                case SUPPLY, RETURN:
                    fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
                    break;
                case PURCHASE:
                    fruits.put(fruit, fruits.getOrDefault(fruit, 0) - quantity);
                    break;
                default:
            }
        }
        return fruits;
    }
}
