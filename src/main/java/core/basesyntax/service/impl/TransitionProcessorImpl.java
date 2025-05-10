package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransitionProcessor;
import java.util.Map;

public class TransitionProcessorImpl implements TransitionProcessor {
    @Override
    public void processTransaction(Map<String, Integer> balanceMap, FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        {

            switch (transaction.getOperation()) {
                case BALANCE -> balanceMap.put(fruit, quantity);
                case SUPPLY, RETURN -> balanceMap.put(fruit,
                        balanceMap.getOrDefault(fruit, 0) + quantity);
                case PURCHASE -> balanceMap.put(fruit,
                        balanceMap.getOrDefault(fruit, 0) - quantity);
                default -> throw new IllegalArgumentException("Invalid transaction type: "
                        + transaction.getOperation());
            }
        }
    }
}
