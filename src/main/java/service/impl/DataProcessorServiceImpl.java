package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.DataProcessorService;
import service.OperationStrategy;

public class DataProcessorServiceImpl implements DataProcessorService {
    private final OperationStrategy operationStrategy;

    public DataProcessorServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> inputData) {
        for (FruitTransaction transaction : inputData) {
            operationStrategy.getOperationHandler(transaction.getOperation()).execute(transaction);
        }
    }
}
