package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {

    @Override
    public void process(List<FruitTransaction> transactions) {
        OperationStrategyImpl strategyImplementation = new OperationStrategyImpl();
        for (FruitTransaction transaction : transactions) {
            OperationStrategy operationStrategy = strategyImplementation
                    .getOperationStrategy(transaction);
            operationStrategy.calculate(transaction);
        }
    }
}
