package core.basesyntax.transaction;

import java.util.Map;

public interface OperationStrategy {
    Map.Entry<Operation, OperationHandler> getOperationHandler(Operation key);
}
