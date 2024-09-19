package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ActionHandler;

public interface ActionStrategy {
    ActionHandler getHandler(FruitTransaction.Action operation);
}
