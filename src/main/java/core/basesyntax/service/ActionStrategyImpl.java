package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.action.ActionHandler;

import java.util.Map;

//public class ActionStrategyImpl implements ActionStrategy {
//    private Map<Account.Operation, ActionHandler> actionHandlerMap;
//
//    public ActionStrategyImpl(Map<Account.Operation, ActionHandler> actionHandlerMap) {
//        this.actionHandlerMap = actionHandlerMap;
//    }
//
//    @Override
//    public ActionHandler get(Account.Operation operation) {
//        return actionHandlerMap.get(operation);
//    }
//}
public class ActionStrategyImpl implements ActionStrategy {
    private Map<Operation, ActionStrategy> operationHandlers;
    public void ActionStrategyImpl(Map<Operation, ActionStrategy> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }
    @Override
    public void execute(FruitTransaction fruitTransaction) {
        ActionStrategy handler = operationHandlers.get(Operation.getOperation(fruitTransaction.));
        handler.execute(fruitTransaction);
    }
}
