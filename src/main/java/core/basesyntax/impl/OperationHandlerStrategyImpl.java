package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.OperationHandlerStrategy;
import core.basesyntax.strategy.BalanceOperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> map = new HashMap<>();

    {
        map.put(FruitTransaction.Operation.BALANCE, new BalanceOperationStrategy());
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return map.get(operation);
    }
}
