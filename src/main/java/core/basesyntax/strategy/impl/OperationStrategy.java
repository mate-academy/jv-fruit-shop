package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation,
            OperationHandler> strategyMap = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
            FruitTransaction.Operation.RETURN, new ReturnHandler());
    private final OperationHandler handler;

    public OperationStrategy(FruitTransaction.Operation operation) {
        handler = strategyMap.get(operation);
    }

    public OperationHandler getHandler() {
        return handler;
    }
}
