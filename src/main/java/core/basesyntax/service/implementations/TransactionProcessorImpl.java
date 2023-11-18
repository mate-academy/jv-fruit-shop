package core.basesyntax.service.implementations;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy strategy;

    public TransactionProcessorImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitInfo) {
        for (FruitTransaction fruitTransaction : fruitInfo) {
            OperationHandler handler = strategy.get(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }
    }
}
