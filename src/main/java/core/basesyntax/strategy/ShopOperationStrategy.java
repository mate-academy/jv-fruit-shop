package core.basesyntax.strategy;

import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.utility.Operation;

public interface ShopOperationStrategy {
    ShopOperationHandler get(Operation operation);
}
