package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AddToBalanceStrategy;
import java.util.Map;

public class AddToBalanceStrategyImpl implements AddToBalanceStrategy {
    @Override
    public void action(Map<String, Integer> dataForReport, String fruit, Integer quantity) {
        if (existFruit(dataForReport, fruit)) {
            dataForReport.put(fruit, quantity);
        } else {
            dataForReport.replace(fruit, dataForReport.get(fruit) + quantity);
        }
    }
}
