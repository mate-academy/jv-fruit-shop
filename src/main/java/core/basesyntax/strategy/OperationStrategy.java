package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.operationhandler.BalanceHandler;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.PurchaseHandler;
import core.basesyntax.service.operationhandler.ReturnHandler;
import core.basesyntax.service.operationhandler.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();

    public OperationStrategy() {
        this.operationHandlerMap = Map.of(
                Operation.BALANCE, new BalanceHandler(),
                Operation.SUPPLY, new SupplyHandler(),
                Operation.RETURN, new ReturnHandler(),
                Operation.PURCHASE, new PurchaseHandler());
    }

    public OperationHandler getHandler(Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
