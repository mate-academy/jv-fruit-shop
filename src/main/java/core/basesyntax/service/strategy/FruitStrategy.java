package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Operation;
import java.util.Map;

public class FruitStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public FruitStrategy(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public OperationHandler findHandlerFor(FruitTransactionDto dto) {
        return handlers.get(dto.operationType());
    }
}
