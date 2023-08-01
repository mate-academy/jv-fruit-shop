package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public interface OperationHandler {
    void completeOperation(Fruit fruit);
}
