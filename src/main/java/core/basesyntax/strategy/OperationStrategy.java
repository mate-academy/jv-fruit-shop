package core.basesyntax.strategy;

import jdk.dynalink.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
