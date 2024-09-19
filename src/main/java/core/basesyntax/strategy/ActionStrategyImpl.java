package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private final Map<FruitTransaction.Action, ActionHandler> handlers;

    public ActionStrategyImpl(Map<FruitTransaction.Action, ActionHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public ActionHandler getHandler(FruitTransaction.Action action) {
        return handlers.get(action);
    }
}
