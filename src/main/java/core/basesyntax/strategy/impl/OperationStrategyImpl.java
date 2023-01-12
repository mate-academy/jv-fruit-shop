package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    public static final Map<FruitTransaction.Operation, OperationHandler> function
            = new HashMap<>();

    static {
        function.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        function.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        function.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        function.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        return function.get(operation);
    }
}
