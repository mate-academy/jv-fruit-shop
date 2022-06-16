package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.processing.OperationProcessing;

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
