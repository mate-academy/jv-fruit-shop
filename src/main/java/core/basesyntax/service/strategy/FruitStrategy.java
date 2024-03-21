package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public class FruitStrategy {
    private final List<OperationHandler> handlers;

    public FruitStrategy(List<OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public OperationHandler findHandlerFor(FruitTransactionDto dto) {
        for (OperationHandler handler : handlers) {
            if (handler.isApplicable(dto)) {
                return handler;
            }
        }
        return null;
    }
}
