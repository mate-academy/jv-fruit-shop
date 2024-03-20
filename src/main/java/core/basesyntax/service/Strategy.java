package core.basesyntax.service;

import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public interface Strategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
