package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.impl.BalanceHandler;
import core.basesyntax.strategy.handler.impl.PurchaseHandler;
import core.basesyntax.strategy.handler.impl.ReturnHandler;
import core.basesyntax.strategy.handler.impl.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<String, OperationHandler> handlerMap;

    public OperationStrategyImpl() {
        handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE.getCode(), new BalanceHandler());
        handlerMap.put(FruitTransaction.Operation.SUPPLY.getCode(), new SupplyHandler());
        handlerMap.put(FruitTransaction.Operation.PURCHASE.getCode(), new PurchaseHandler());
        handlerMap.put(FruitTransaction.Operation.RETURN.getCode(), new ReturnHandler());
    }

    @Override
    public OperationHandler getHandler(FruitTransaction transaction) {
        return handlerMap.get(transaction.getOperation().getCode());
    }
}
