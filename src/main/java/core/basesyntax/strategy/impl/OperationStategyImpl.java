package core.basesyntax.strategy.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationStategy;
import java.util.Map;

public class OperationStategyImpl implements OperationStategy {

    private Map<Operation, OperationHandler> operationStrategyMap;

    public OperationStategyImpl(Map<Operation, OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public OperationHandler get(FruitTransactionDto dto) {
        Operation operation = Operation.fromCode(dto.getOperationType());
        return operationStrategyMap.get(operation);
    }
}
