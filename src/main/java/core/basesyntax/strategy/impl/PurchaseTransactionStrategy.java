package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitStrategy;
import java.util.Map;

public class PurchaseTransactionStrategy implements FruitStrategy {
    @Override
    public void process(Map<String, Integer> dataBase, String fruit, int quantity) {

        if (dataBase.containsKey(fruit)) {
            int currentQuantity = dataBase.get(fruit);
            if (currentQuantity >= quantity) {
                dataBase.put(fruit, currentQuantity - quantity);
            } else {
                System.out.println("Warning: Not enough " + fruit + " in inventory.");
            }
        } else {
            System.out.println("Warning: " + fruit + " not found in inventory.");
        }
    }
}
