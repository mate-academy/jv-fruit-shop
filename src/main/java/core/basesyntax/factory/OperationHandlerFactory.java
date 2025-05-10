package core.basesyntax.factory;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;

public interface OperationHandlerFactory {
    OperationHandler getHandler(Operation operation);
}
