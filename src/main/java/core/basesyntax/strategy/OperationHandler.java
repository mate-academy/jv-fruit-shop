package core.basesyntax.strategy;

import core.basesyntax.model.FruitRecord;

public interface OperationHandler {
    int getChangedAmount(FruitRecord record);
}
