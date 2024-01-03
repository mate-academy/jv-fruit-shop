package core.basesyntax.strategy;

import core.basesyntax.model.Store;
import core.basesyntax.strategy.operation.Handler;

public interface Strategy {
    Handler getOperation(Store.Operation operation);
}
