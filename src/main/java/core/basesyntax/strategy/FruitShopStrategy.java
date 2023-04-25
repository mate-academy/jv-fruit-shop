package core.basesyntax.strategy;

import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.utils.Operation;

public interface FruitShopStrategy {
    OperationHandler get(Operation operation);
}
