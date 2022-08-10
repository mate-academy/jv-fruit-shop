package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationStrategy strategy;

    public FruitTransactionProcessorImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions
                .forEach(t -> {
                    OperationHandler handler = strategy.getStrategy(t);
                    handler.handle(t);
                });
    }
}
