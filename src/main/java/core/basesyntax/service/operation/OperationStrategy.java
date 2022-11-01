package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler get(String typeOfStrategy);

    void fillOperationsList(Map<Operation, OperationHandler> strategies);
}
