package core.basesyntax.service;

import core.basesyntax.model.Account;
import core.basesyntax.service.action.ActionHandler;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private Map<Account.Operation, ActionHandler> actionHandlerMap;

    public ActionStrategyImpl(Map<Account.Operation, ActionHandler> actionHandlerMap) {
        this.actionHandlerMap = actionHandlerMap;
    }

    @Override
    public ActionHandler get(Account.Operation operation) {
        return actionHandlerMap.get(operation);
    }
}
