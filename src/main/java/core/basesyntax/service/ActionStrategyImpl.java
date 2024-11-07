package core.basesyntax.service;

import core.basesyntax.model.Account;
import core.basesyntax.service.action.ActionHandler;

import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    public ActionStrategyImpl(Map<Account.Operation, ActionHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    private Map<Account.Operation, ActionHandler> actionHandlerMap;
    @Override
    public ActionHandler get(Account.Operation operation) {
        return actionHandlerMap.get(operation);
    }
}
