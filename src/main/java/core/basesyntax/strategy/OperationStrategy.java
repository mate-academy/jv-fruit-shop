package core.basesyntax.strategy;

import core.basesyntax.operation.Operation;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public interface OperationStrategy {
    Map.Entry<Operation, OperationHandler> getOperationHandler(Operation key);
}
