package core.basesyntax.service.impl;

import core.basesyntax.model.FruitNegotiation;
import core.basesyntax.service.FruitEvaluator;
import core.basesyntax.strategy.ApplayStrategy;
import core.basesyntax.strategy.impl.ApplayStrategyImpl;
import java.util.List;

public class FruitEvaluatorImpl implements FruitEvaluator {
    private ApplayStrategy applayStrategy = new ApplayStrategyImpl();

    @Override
    public void evaluate(List<FruitNegotiation> parsedData) {
        for (FruitNegotiation record : parsedData) {
            applayStrategy.process(record);
        }
    }
}
