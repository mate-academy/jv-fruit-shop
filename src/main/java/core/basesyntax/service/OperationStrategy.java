package core.basesyntax.service;

import core.basesyntax.model.FruitShopTransactions;
import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitShopTransactions.Operation operation);
}
