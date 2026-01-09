package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import java.util.EnumMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Storage.Operation, OperationHandler> handlers =
            new EnumMap<>(Storage.Operation.class);

    public OperationStrategyImpl() {
        handlers.put(Storage.Operation.BALANCE, new BalanceOperation());
        handlers.put(Storage.Operation.SUPPLY, new SupplyOperation());
        handlers.put(Storage.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(Storage.Operation.RETURN, new ReturnOperation());
    }

    @Override
    public OperationHandler get(Storage.Operation operation) {
        OperationHandler handler = handlers.get(operation);
        if (handler == null) {
            throw new RuntimeException(
                    "No handler for operation: " + operation);
        }
        return handler;
    }
}
