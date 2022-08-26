package core.basesyntax.strategy.operations;

import core.basesyntax.model.FruitTransaction;

public interface DailyOperationHandler {
    public void apply(FruitTransaction dailyTransaction);
}
