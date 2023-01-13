package solid.service.impl;

import java.util.List;
import solid.model.FruitTransaction;
import solid.service.TransactionProcessor;
import solid.strategy.OperationStrategy;
import solid.strategy.impl.OperationStrategyImpl;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(t -> operationStrategy.getOperationHandler(t.getOperation())
                .apply(t));
    }
}
