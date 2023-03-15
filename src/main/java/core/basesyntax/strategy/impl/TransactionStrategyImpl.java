package core.basesyntax.strategy.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<TransactionDto.Operation, OperationHandler> operationsMap;

    public TransactionStrategyImpl(Map<TransactionDto.Operation,
            OperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public OperationHandler get(TransactionDto.Operation operation) {
        return operationsMap.get(operation);
    }
}
