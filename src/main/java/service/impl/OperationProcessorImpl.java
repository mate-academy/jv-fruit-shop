package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationStrategy;
import service.operation.OperationProcessor;

public class OperationProcessorImpl implements OperationProcessor {
    @Override
    public void processConvertedData(List<FruitTransaction> fruitTransactionList,
                                     OperationStrategy operationStrategy) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationStrategy.update(fruitTransaction).operate(fruitTransaction);
        }
    }
}
