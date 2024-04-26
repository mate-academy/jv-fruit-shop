package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.FruitTransactionProcessor;
import service.OperationStrategy;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public void process(List<FruitTransaction> fruitTransactionsList) {
        for (FruitTransaction fruitTransaction : fruitTransactionsList) {
            operationStrategy
                    .getOperationHandler(fruitTransaction.getOperation())
                    .handleTransaction(fruitTransaction);
        }
    }
}
