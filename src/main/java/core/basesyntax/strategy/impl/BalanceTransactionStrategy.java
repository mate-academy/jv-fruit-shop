package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.FruitStrategy;
import java.util.Map;

public class BalanceTransactionStrategy implements FruitStrategy {

    @Override
    public void process(Map<String, Integer> dataBase, String fruit, int quantity) {

        if (dataBase.containsKey(fruit)) {
            quantity += dataBase.get(fruit);
        }
        dataBase.put(fruit, quantity);
    }
}
