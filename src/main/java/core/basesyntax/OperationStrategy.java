package core.basesyntax;

import core.basesyntax.model.FruitsTransaction;

import java.util.List;

public class OperationStrategy {
    private final List<OperationHandler> handlers;

    public OperationStrategy(List<OperationHandler> handlers) {
        this.handlers = handlers;
    }

    public List<OperationHandler> getHandlers(FruitsTransaction dto) {
        return handlers.stream()
                .filter(n -> n.isApplicable(dto))
                .toList();
    }
}
