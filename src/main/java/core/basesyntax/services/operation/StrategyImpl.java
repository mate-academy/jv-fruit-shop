package core.basesyntax.services.operation;

import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<TransactionDto.Type, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<TransactionDto.Type, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(TransactionDto.Type operation) {
        if (operationHandlerMap.get(operation) == null) {
            throw new RuntimeException("Unsupported operation");
        }
        return operationHandlerMap.get(operation);
    }
}
