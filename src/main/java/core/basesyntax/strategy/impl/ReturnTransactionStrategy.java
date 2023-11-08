package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitStrategy;
import java.util.Map;

public class ReturnTransactionStrategy implements FruitStrategy {

    @Override
    public void process(Map<String, Integer> dataBase, String fruit, int quantity) {

        if (dataBase.containsKey(fruit)) {
            int currentQuantity = dataBase.get(fruit);
            dataBase.put(fruit, currentQuantity + quantity);
        } else {
            System.out.println("Warning: " + fruit + " not found in inventory for return.");
        }
    }
}
