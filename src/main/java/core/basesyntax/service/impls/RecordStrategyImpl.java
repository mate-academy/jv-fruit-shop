package core.basesyntax.service.impls;

import core.basesyntax.service.RecordStrategy;
import core.basesyntax.service.handler.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class RecordStrategyImpl implements RecordStrategy {
    private final Map<String, OperationHandler> operationHandlerMap;

    public RecordStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public Optional<OperationHandler> get(String action) {
        return Optional.ofNullable(operationHandlerMap.get(action));
    }
}
