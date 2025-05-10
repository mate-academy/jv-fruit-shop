package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitRecord;

public interface OperationHandler {
    void apply(FruitRecord transaction);
}
