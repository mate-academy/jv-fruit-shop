package core.basesyntax.strategy;

import core.basesyntax.strategy.operation.StorageOperationHandler;

public interface StorageOperationStrategy {
    StorageOperationHandler getOperationHandler();
}
