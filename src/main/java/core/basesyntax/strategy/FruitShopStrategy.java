package core.basesyntax.strategy;

import core.basesyntax.service.OperationHandler;

public interface FruitShopStrategy {
    OperationHandler get(String operation);
}
