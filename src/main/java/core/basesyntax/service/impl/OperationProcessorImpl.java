package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationProcessor;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class OperationProcessorImpl implements OperationProcessor {
    private final Map<FruitTransaction.Operation, OperationHandler> operationStrategies;

    public OperationProcessorImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategies.get(fruitTransaction.getOperation()).apply(fruitTransaction);
        }
    }
}
