package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceSupplyStrategy implements OperationStrategy {
    @Override
    public void handleTransaction(FruitTransaction transaction, Map<String, Integer> fruitStore) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        fruitStore.put(fruit, fruitStore.getOrDefault(fruit, 0) + quantity);
    }
}
