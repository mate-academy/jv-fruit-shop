package core.basesyntax.services;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.actions.ActionHandler;

public interface ActionStrategy {
    ActionHandler get(FruitTransaction.ActionType type);
}
