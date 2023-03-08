package core.basesyntax.strategy;

import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.strategy.actions.ActionWithFruits;

public interface ActionsStrategy {
    ActionWithFruits get(TypeOfOperation type);
}
