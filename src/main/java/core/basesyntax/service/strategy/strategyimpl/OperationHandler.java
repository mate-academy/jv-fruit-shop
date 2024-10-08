package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.model.FruitRecord;

public interface OperationHandler {
    void apply(FruitRecord transaction);
}
