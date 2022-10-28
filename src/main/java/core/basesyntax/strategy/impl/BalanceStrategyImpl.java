package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.BalanceStrategy;
import java.util.Map;

public class BalanceStrategyImpl implements BalanceStrategy {
    @Override
    public void action(Map<String, Integer> dataForReport, String fruit, Integer quantity) {
        if (existFruit(dataForReport, fruit)) {
            dataForReport.put(fruit, quantity);
        } else {
            dataForReport.replace(fruit, dataForReport.get(fruit) + quantity);
        }
    }
}
