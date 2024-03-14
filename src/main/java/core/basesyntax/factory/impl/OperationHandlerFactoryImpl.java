package core.basesyntax.factory.impl;

import core.basesyntax.factory.OperationHandlerFactory;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseStrategyImpl;
import core.basesyntax.strategy.impl.ReturnStrategyImpl;
import core.basesyntax.strategy.impl.SupplyStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationHandlerFactoryImpl implements OperationHandlerFactory {
    private final Map<Operation, OperationHandler> operations = new HashMap<>();

    public OperationHandlerFactoryImpl() {
        operations.put(Operation.BALANCE, new BalanceStrategyImpl());
        operations.put(Operation.RETURN, new ReturnStrategyImpl());
        operations.put(Operation.PURCHASE, new PurchaseStrategyImpl());
        operations.put(Operation.SUPPLY, new SupplyStrategyImpl());
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        OperationHandler handler = operations.get(operation);
        if (handler == null) {
            throw new RuntimeException("Unknown operation" + operation);
        }
        return handler;
    }
}
