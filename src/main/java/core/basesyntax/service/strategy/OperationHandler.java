package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    public void apply(FruitTransaction transaction);
}
