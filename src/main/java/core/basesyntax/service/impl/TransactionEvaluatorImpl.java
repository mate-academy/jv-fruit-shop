package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionEvaluator;
import core.basesyntax.strategy.ApplyStrategy;
import core.basesyntax.strategy.impl.ApplyStrategyImpl;
import java.util.List;

public class TransactionEvaluatorImpl implements TransactionEvaluator {
    private ApplyStrategy applayStrategy = new ApplyStrategyImpl();

    @Override
    public void evaluate(List<FruitTransaction> transactions) {
        for (FruitTransaction record : transactions) {
            applayStrategy.process(record);
        }
    }
}
