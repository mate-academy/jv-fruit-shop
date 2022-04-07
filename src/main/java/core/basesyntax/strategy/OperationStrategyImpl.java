package core.basesyntax.strategy;

import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.ReturnHandler;
import core.basesyntax.handlers.SupplyHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    public static final Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap = new HashMap<>();

    public OperationStrategyImpl() {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
    }

    @Override
    public void activity(FruitTransaction.Operation operation, String fruit, Integer quantity) {
        for (Map.Entry<FruitTransaction.Operation, OperationHandler> entry :
                operationHandlerMap.entrySet()) {
            if (entry.getKey().equals(operation)) {
                entry.getValue().process(fruit, quantity);
            }
        }
    }
}
