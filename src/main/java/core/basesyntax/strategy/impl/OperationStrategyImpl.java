package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void getOperation(FruitTransaction fruitTransaction) {
        operationStrategyMap.get(fruitTransaction.getOperation())
                .processFruitTransactionOperation(fruitTransaction);
    }
}
