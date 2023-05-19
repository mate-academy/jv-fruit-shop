package core.basesyntax.strategy.impl;

import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReturnOperationHandler;
import core.basesyntax.service.impl.SupplyOperationHandler;
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
