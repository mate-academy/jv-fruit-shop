package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.transaction.Operation;

import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<Operation, OperationHandler> strategies = Map.of(
            Operation.BALANCE, new BalanceOperationHandler(),
            Operation.PURCHASE, new PurchaseOperationHandler(),
            Operation.RETURN, new ReturnOperationHandler(),
            Operation.SUPPLY, new SupplyOperationHandler()
    );

    public OperationHandler getOperationService(Operation operation) {
        return strategies.get(operation);
    }
}
