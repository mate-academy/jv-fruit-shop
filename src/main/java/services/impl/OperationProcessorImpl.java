package services.impl;

import java.util.List;
import model.FruitTransaction;
import services.OperationProcessor;
import strategy.OperationStrategy;

public class OperationProcessorImpl implements OperationProcessor {
    private OperationStrategy operationStrategy;

    public OperationProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> data) {
        for (FruitTransaction fruitTransaction : data) {
            operationStrategy.getHandler(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
    }
}
