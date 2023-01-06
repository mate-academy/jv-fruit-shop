package core.basesyntax.strategy;

import core.basesyntax.optration.OperationHandler;
import jdk.dynalink.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
