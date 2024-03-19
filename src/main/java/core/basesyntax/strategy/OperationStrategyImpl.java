package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class OperationStrategyImpl implements OperationStrategy {
    private final List<OperationHandler> handlers;

    public OperationStrategyImpl(List<OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public List<OperationHandler> getHandlers(FruitTransaction transaction) {
        return handlers.stream()
                .filter(h -> h.isAplicable(transaction))
                .toList();
    }
}
