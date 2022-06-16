package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.processing.OperationProcessing;
import core.basesyntax.strategy.OperationProcessingStrategy;
import java.util.Map;

public class OperationProcessingStrategyImpl implements OperationProcessingStrategy {
    private Map<FruitTransaction.Operation, OperationProcessing> operationProcessingMap;

    public OperationProcessingStrategyImpl(Map<FruitTransaction.Operation,
            OperationProcessing> operationProcessingMap) {
        this.operationProcessingMap = operationProcessingMap;
    }

    @Override
    public OperationProcessing get(FruitTransaction.Operation operation) {
        return operationProcessingMap.get(operation);
    }
}
