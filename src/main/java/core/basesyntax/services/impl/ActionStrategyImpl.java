package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.ActionStrategy;
import core.basesyntax.services.actions.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private Map<FruitTransaction.ActionType, ActionHandler> actionHandlerMap;

    public ActionStrategyImpl(Map<FruitTransaction.ActionType, ActionHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    @Override
    public ActionHandler get(FruitTransaction.ActionType type) {
        return actionHandlerMap.get(type);
    }
}
