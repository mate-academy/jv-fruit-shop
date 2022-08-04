package core.basesyntax.transactionprocessorimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transactionprocessor.FruitTransactionProcessor;
import core.basesyntax.transactionprocessor.OperationHandler;
import core.basesyntax.transactionprocessor.OperationStrategy;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private static final OperationStrategy STRATEGY = new OperationStrategyImpl();

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions
                .forEach(t -> {
                    OperationHandler handler = STRATEGY.getImplementation(t);
                    handler.handle(t);
                });
    }
}
