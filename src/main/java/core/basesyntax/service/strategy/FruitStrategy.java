package core.basesyntax.service.strategy;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public class FruitStrategy {
    private final List<OperationHandler> handlers;

    public FruitStrategy(List<OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public List<OperationHandler> getHandlers(FruitTransactionDto dto) {
        return handlers.stream()
                .filter(h -> h.isApplicable(dto))
                .toList();
    }
}
