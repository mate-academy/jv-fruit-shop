package core.basesyntax.service.strategy;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operations.OperationHendler;
import java.util.Map;

public class OperationsStrategyImpl implements OperationsStrategy {
    private final Map<TransactionDto.OperationTypes, OperationHendler> operationHendlers;

    public OperationsStrategyImpl(Map<TransactionDto.OperationTypes,
            OperationHendler> operationHendlers) {
        this.operationHendlers = operationHendlers;
    }

    @Override
    public OperationHendler get(TransactionDto.OperationTypes operationTypes) {
        return operationHendlers.get(operationTypes);
    }
}
