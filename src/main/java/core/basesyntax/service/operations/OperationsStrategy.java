package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;

public interface OperationsStrategy {
    OperationsHandler get(Operations operation);
}
