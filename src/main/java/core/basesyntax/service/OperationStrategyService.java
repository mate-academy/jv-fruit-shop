package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategyService {

    OperationHandler getOperationHandler(FruitTransaction.Operation operation);
}
