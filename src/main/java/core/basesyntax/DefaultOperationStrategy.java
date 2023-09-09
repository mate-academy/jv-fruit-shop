package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class DefaultOperationStrategy implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();

    public DefaultOperationStrategy() {
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlers.get(operation);
    }
}
