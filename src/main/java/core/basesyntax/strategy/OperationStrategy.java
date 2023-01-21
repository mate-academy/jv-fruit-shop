package core.basesyntax.strategy;

import static core.basesyntax.model.Operation.BALANCE;
import static core.basesyntax.model.Operation.PURCHASE;
import static core.basesyntax.model.Operation.RETURN;
import static core.basesyntax.model.Operation.SUPPLY;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {

    private final Map<Operation, OperationHandler> operationStrategyMap = new HashMap<>();

    public OperationStrategy() {
        operationStrategyMap.put(PURCHASE,new PurchaseOperationHandler());
        operationStrategyMap.put(SUPPLY, new SupplyOperationHandler());
        operationStrategyMap.put(RETURN,new ReturnOperationHandler());
        operationStrategyMap.put(BALANCE,new BalanceOperationHandler());
    }

    public OperationHandler getOperationHandler(Operation operation) {
        return operationStrategyMap.get(operation);
    }
}
