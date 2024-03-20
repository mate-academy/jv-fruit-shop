package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.operations.OperationHandler;
import java.util.List;

public class OperationStrategy {
    private final List<OperationHandler> handlers;

    public OperationStrategy(List<OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public List<OperationHandler> getHandlers(FruitTransactionDto dto) {
        return handlers.stream()
                .filter(h -> h.isApplicable(dto))
                .toList();
    }
}
