package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHendler;

public interface OperationStrategy {
    OperationHendler get(FruitTransaction.Operation type);
}
