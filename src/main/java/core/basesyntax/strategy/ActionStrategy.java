package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.strategy.actions.ActionHandler;

public interface ActionStrategy {
    ActionHandler get(FruitTransaction.Operation action);
}
