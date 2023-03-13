package core.basesyntax.service.impl;

import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.service.FruitEvaluator;
import core.basesyntax.strategy.ApplyStrategy;
import core.basesyntax.strategy.impl.ApplyStrategyImpl;
import java.util.List;

public class FruitEvaluatorImpl implements FruitEvaluator {
    private ApplyStrategy applayStrategy = new ApplyStrategyImpl();

    @Override
    public void evaluate(List<FruitNegotiation> parsedData) {
        for (FruitNegotiation record : parsedData) {
            applayStrategy.process(record);
        }
    }
}
