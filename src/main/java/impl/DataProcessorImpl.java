package impl;

import java.util.List;
import model.FruitTransaction;
import service.DataProcessor;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class DataProcessorImpl implements DataProcessor {
    private OperationStrategy operationStrategy;

    public DataProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy
                    .getHandler(transaction.getOperation());
            operationHandler.apply(transaction);
        }
    }
}
