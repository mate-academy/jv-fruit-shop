package core.basesyntax.serviceimpl;

import core.basesyntax.strategyimpl.StrategyImpl;

import java.util.List;

public class CalculateValues {
    public void getFruitsAndValues(List<FruitTransaction> info) {
        StrategyImpl strategy = new StrategyImpl();
        for (FruitTransaction operation : info) {
            strategy.get(operation.getOperation())
                    .calculateValue(operation.getFruit(), operation.getQuantity());
        }
    }
}

