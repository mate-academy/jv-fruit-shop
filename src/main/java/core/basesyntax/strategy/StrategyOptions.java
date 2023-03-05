package core.basesyntax.strategy;

import core.basesyntax.actions.DoingAction;
import core.basesyntax.model.FruitTransaction;

public interface StrategyOptions {
    DoingAction get(FruitTransaction.Operation type);
}
