package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private OperationStrategy operationStrategy;

    public DataProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addDataToDB(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getOperationStrategy(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
    }
}
