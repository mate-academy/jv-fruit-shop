package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface ProcessHandler {
    Integer processTransaction(FruitTransaction operation);
}
