package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private static final Map<FruitTransaction.Operation,
            OperationHandler> strategyMap;

    static {
        strategyMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler());
    }

    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return strategyMap.get(operation);
    }
}
