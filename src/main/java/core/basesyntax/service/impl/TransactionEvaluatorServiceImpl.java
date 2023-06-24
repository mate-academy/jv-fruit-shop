package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionEvaluatorService;
import core.basesyntax.strategy.CalculationStrategy;
import java.util.List;

public class TransactionEvaluatorServiceImpl implements TransactionEvaluatorService {
    private final CalculationStrategy strategy;

    public TransactionEvaluatorServiceImpl(CalculationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.calculate(transaction);
        }
    }
}
