package strategy;

import dto.FruitTransactionDto;
import java.util.List;
import service.operations.OperationHandler;

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
