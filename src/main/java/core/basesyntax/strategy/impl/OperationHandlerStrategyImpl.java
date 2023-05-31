package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategies
            = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl(),
            FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());

    @Override
    public OperationHandler getOperationStrategy(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}
