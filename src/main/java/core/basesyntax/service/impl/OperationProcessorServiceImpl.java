package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcessorService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class OperationProcessorServiceImpl implements OperationProcessorService {
    private final OperationStrategy operationStrategy;

    public OperationProcessorServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        for (FruitTransaction fruitTransaction : transactionList) {
            operationStrategy.get(fruitTransaction.getOperation()).process(fruitTransaction);
        }
    }
}
