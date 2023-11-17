package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    Integer processTransaction(FruitTransaction transaction);
}
