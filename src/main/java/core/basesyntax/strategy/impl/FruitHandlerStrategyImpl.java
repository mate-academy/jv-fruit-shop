package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitHandlerStrategy;
import java.util.Map;

public class FruitHandlerStrategyImpl implements FruitHandlerStrategy {
    private Map<FruitTransaction.Operation, FruitHandler> strategies
            = Map.of(FruitTransaction.Operation.BALANCE, new BalanceImpl(),
            FruitTransaction.Operation.PURCHASE, new PurchaseImpl(),
            FruitTransaction.Operation.RETURN, new ReturnImpl(),
            FruitTransaction.Operation.SUPPLY, new SupplyImpl());

    public FruitHandler getOperationService(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}
