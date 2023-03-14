package core.basesyntax.strategy.impl;

import core.basesyntax.service.operation.DefaultOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final List<OperationHandler> handlerList;
    private final DefaultOperationHandler defaultHandler;

    public TransactionStrategyImpl(List<OperationHandler> handlerList) {
        this.handlerList = handlerList;
        defaultHandler = new DefaultOperationHandler();
    }

    @Override
    public OperationHandler get(String operation) {
        return handlerList.stream()
                .filter(h -> h.isApplicable(operation))
                .findFirst()
                .orElse(defaultHandler);
    }
}
