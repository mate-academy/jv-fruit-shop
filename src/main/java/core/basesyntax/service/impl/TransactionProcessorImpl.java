package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandle;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import jdk.dynalink.Operation;

import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }


    @Override
    public void process(List<FruitTransaction> fruitsInfo) {
        for (FruitTransaction fruitInfo: fruitsInfo) {
            OperationHandle handle =  operationStrategy.get(fruitInfo.getOperation());
            handle.handle(fruitInfo);
        }

    }
}
