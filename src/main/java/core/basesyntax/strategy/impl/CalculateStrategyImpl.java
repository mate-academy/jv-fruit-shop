package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.CalculateStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class CalculateStrategyImpl implements CalculateStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
            FruitTransaction.Operation.RETURN, new ReturnHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyHandler()
    );

    @Override
    public OperationHandler getHandler(FruitTransaction transaction) {
        return operationHandlers.get(transaction.getOperation());
    }
}
