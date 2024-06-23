package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class TransactionProcessor {
    private Map<String, Integer> fruits;

    public void process(FruitTransaction transaction) {
        if (transaction == null) {
            throw new RuntimeException("Transaction is null");
        }
        String fruit = transaction.fruit();
        int quantity = transaction.quantity();
        switch (transaction.operation()) {
            case BALANCE:
                fruits.put(fruit, quantity);
                break;
            case SUPPLY, RETURN:
                Storage.fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
                break;
            case PURCHASE:
                Storage.fruits.put(fruit, fruits.getOrDefault(fruit, 0) - quantity);
                break;
            default:
        }
    }
}
