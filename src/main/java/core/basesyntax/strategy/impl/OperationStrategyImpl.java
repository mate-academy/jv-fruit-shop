package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> strategies
            = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
            FruitTransaction.Operation.RETURN, new ReturnOperationHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());

    public OperationHandler getOperationService(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}
