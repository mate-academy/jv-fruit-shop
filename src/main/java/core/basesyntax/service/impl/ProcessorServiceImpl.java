package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessorService;
import core.basesyntax.strategy.OperationStrategy;

public class ProcessorServiceImpl implements ProcessorService {
    private final OperationStrategy operationStrategy;

    public ProcessorServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(FruitTransaction transaction) {
        operationStrategy.get(transaction.getOperation()).operate(transaction);
    }
}
