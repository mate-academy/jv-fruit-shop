package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.ReturnStrategy;
import java.util.Map;

public class ReturnStrategyImpl implements ReturnStrategy {
    @Override
    public void action(Map<String, Integer> dataForReport, String fruit, Integer quantity) {
        if (existFruit(dataForReport, fruit)) {
            dataForReport.put(fruit, quantity);
        } else {
            dataForReport.replace(fruit, dataForReport.get(fruit) + quantity);
        }
    }
}
