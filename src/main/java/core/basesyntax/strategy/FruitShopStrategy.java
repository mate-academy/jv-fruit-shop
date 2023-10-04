package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public interface FruitShopStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
