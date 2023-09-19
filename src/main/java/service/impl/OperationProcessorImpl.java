package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationStrategy;
import service.operation.OperationProcessor;

public class OperationProcessorImpl implements OperationProcessor {
    private OperationStrategy operationStrategy;

    public OperationProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processConvertedData(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationStrategy.getOperationHandler(fruitTransaction).operate(fruitTransaction);
        }
    }
}
