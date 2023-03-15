package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.strategy.actions.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private final Map<FruitTransaction.Operation, ActionHandler> actions;

    public ActionStrategyImpl(Map<FruitTransaction.Operation, ActionHandler> actions) {
        this.actions = actions;
    }

    public ActionHandler get(FruitTransaction.Operation action) {
        return actions.get(action);
    }
}
