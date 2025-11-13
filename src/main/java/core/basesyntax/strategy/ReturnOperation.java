package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> inventory) {
        String fruit = transaction.getFruit();
        int current = inventory.getOrDefault(fruit, 0);
        inventory.put(fruit, current + transaction.getQuantity());
    }
}
