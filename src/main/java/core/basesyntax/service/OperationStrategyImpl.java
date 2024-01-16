package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationProvider;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationProvider> operationProviderMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationProvider> operationProviderMap) {
        this.operationProviderMap = operationProviderMap;
    }

    @Override
    public OperationProvider get(FruitTransaction.Operation operation) {
        return operationProviderMap.get(operation);
    }
}
