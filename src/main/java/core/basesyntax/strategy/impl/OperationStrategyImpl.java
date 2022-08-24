package core.basesyntax.strategy.impl;

import core.basesyntax.enums.TurnoverType;
import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.hadler.impl.AddOperationHandler;
import core.basesyntax.hadler.impl.SubtractOperationHandler;
import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler getOperationHandler(TurnoverType type) {
        switch (type) {
            case ADD:
                return new AddOperationHandler();
            case SUBTRACT:
            default:
                return new SubtractOperationHandler();
        }
    }
}
