package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler {

    public Map<FruitTransaction.Operation, OperationHandler> initHandlers() {
        Map<FruitTransaction.Operation, OperationHandler> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationStrategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        return operationStrategies;
    }
}
