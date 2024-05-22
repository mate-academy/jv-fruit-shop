package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;

public interface OperationsHandler {
    Operations getOperation();

    int getOperationsResult(int result, int quantity);
}
