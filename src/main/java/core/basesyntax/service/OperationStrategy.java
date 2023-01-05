package core.basesyntax.service;

import jdk.dynalink.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
