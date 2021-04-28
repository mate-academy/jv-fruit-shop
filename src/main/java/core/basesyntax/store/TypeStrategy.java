package core.basesyntax.store;

import core.basesyntax.model.OperationType;
import core.basesyntax.store.strategy.TypeHandler;

public interface TypeStrategy {
    TypeHandler get(OperationType operationType);
}
