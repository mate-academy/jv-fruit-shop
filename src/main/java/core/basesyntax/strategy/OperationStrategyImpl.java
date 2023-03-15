package core.basesyntax.strategy;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.model.Operation;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl() {
        this.operationHandlerMap = new HashMap<>();
        this.operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        this.operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        this.operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        this.operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
