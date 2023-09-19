package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.handlers.BalanceHandler;
import core.basesyntax.service.strategy.handlers.PurchaseHandler;
import core.basesyntax.service.strategy.handlers.ReturnHandler;
import core.basesyntax.service.strategy.handlers.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class HandleTransactionStrategyImpl implements HandleTransactionStrategy {
    private static final Map<FruitTransaction.Operation, TransactionHandler>
            operationHandlerMap = new HashMap<>();

    static {
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation type) {
        return operationHandlerMap.get(type);
    }
}
