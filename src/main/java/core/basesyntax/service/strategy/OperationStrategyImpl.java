package core.basesyntax.service.strategy;

import core.basesyntax.service.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.service.strategy.handlers.OperationHandler;
import core.basesyntax.service.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.service.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.service.strategy.handlers.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static Map<String, OperationHandler> map = new HashMap<>();

    static {
        map.put("b", new BalanceOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new ReturnOperationHandler());
        map.put("s", new SupplyOperationHandler());
    }

    @Override
    public OperationHandler get(String operationType) {
        return map.get(operationType);
    }
}
