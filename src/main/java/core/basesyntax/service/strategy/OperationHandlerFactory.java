package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import java.util.HashMap;
import java.util.Map;

public class OperationHandlerFactory {
    private final Map<Operation, OperationHandler> strategyMap = new HashMap<>();

    {
        strategyMap.put(Operation.BALANCE, new BalanceOperationHandler());
        strategyMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        strategyMap.put(Operation.RETURN, new ReturnOperationHandler());
        strategyMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
    }

    public OperationHandler get(FruitTransaction fruitTransaction) {
        return strategyMap.get(fruitTransaction.getOperation());
    }
}
