package core.basesyntax.strategy.impl;

import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> strategiesMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> strategiesMap) {
        this.strategiesMap = strategiesMap;
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return Optional.ofNullable(strategiesMap.get(operation))
                .orElseThrow(() -> new NoSuchElementException("Cannot find OperationHandler "
                        + "for operation = [" + operation + "]"));
    }
}
