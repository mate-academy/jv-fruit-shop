package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;

import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private Map<Transaction.Operation, OperationHandler> strategies
            = Map.of(Transaction.Operation.BALANCE, new BalanceOperationHandler(),
            Transaction.Operation.SUPPLY, new SupplyOperationHandler(),
            Transaction.Operation.PURCHASE, new PurchaseOperationHandler(),
            Transaction.Operation.BALANCE, new ReturnOperationHandler()
    );
    @Override
    public OperationHandler getOperationHandler(Transaction.Operation operation) {
        return strategies.get(operation);
    }
}
