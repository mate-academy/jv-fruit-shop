package core.basesyntax.strategy;

import core.basesyntax.handler.ShopOperationHandler;

public interface ShopOperationStrategy {
    ShopOperationHandler get(String operationName);
}
