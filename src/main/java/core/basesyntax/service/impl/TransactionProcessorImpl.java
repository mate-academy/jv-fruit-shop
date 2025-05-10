package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private OperationStrategyImpl strategyImplementation = new OperationStrategyImpl();

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach((transaction) -> {
            strategyImplementation.getOperationStrategy(transaction).calculate(transaction);
        });
    }
}
