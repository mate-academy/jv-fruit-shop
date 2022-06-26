package core.basesyntax.service;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.strategy.OperationHandler;

public interface OperationMap {
    OperationHandler get(FruitShopTransactions.Operation operation);
}
