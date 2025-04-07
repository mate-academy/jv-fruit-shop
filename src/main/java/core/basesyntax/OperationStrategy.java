package core.basesyntax;

import model.Operation;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
