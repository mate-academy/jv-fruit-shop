package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceHandler;
import core.basesyntax.strategy.handler.impl.PurchaseHandler;
import core.basesyntax.strategy.handler.impl.ReturnHandler;
import core.basesyntax.strategy.handler.impl.SupplyHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap
            = Map.of(FruitTransaction.Operation.BALANCE, new BalanceHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
            FruitTransaction.Operation.RETURN, new ReturnHandler());

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
