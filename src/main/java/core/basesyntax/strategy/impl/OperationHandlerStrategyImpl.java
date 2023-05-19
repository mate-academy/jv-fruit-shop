package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private Map<String, OperationHandler> strategies
            = Map.of("b", new BalanceOperationHandler(), "p", new PurchaseOperationHandler(),
            "r", new ReturnOperationHandler(), "s", new SupplyOperationHandler());

    public OperationHandler getOperationService(String operation) {
        return strategies.get(operation);
    }
}
