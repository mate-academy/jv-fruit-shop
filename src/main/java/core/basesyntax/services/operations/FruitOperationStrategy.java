package core.basesyntax.services.operations;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public class FruitOperationStrategy {
    private final List<OperationHandler> handlers;

    public FruitOperationStrategy(List<OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public List<OperationHandler> getHandler(FruitTransactionDto dto) {
        return handlers.stream()
                .filter((operationHandler -> operationHandler.isApplicable(dto)))
                .toList();
    }
}
