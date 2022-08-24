package core.basesyntax.strategy;

import core.basesyntax.enums.TurnoverType;
import core.basesyntax.hadler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(TurnoverType type);
}
