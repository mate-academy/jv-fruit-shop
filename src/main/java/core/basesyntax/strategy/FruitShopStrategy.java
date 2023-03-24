package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;

public interface FruitShopStrategy {
    OperationHandler get(Operation operation);
}
