package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionsProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionsProcessorImpl implements FruitTransactionsProcessor {
    private OperationStrategy operationStrategy;

    public FruitTransactionsProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .handle(fruitTransaction.getFruit(),
                            fruitTransaction.getQuantity());
        }
    }
}
