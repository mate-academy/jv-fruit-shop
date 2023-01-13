package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.operations.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<Operation, OperationHandler> map;

    public StrategyImpl(Map<Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getByOperation(Operation operation) {
        return map.get(operation);
    }
}
