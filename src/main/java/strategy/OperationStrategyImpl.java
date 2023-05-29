package strategy;

import java.util.Map;
import strategy.handler.BalanceOperationHandler;
import strategy.handler.PurchaseOperationHandler;
import strategy.handler.ReturnOperationHandler;
import strategy.handler.SupplyOperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<String, OperationHandler> operationHalndlerMap;

    static {
        operationHalndlerMap = Map.of(
                "b", new BalanceOperationHandler(),
                "s", new SupplyOperationHandler(),
                "p", new PurchaseOperationHandler(),
                "r", new ReturnOperationHandler());
    }

    @Override
    public OperationHandler get(String codeOperation) {
        return operationHalndlerMap.get(codeOperation);
    }
}
