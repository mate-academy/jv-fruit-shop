package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.strategy.handler.BalanceHandler;
import core.basesyntax.service.strategy.handler.OperationHandler;
import core.basesyntax.service.strategy.handler.PurchaseHandler;
import core.basesyntax.service.strategy.handler.ReturnHandler;
import core.basesyntax.service.strategy.handler.SupplyHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> map =
            Map.of(Operation.BALANCE, new BalanceHandler(),
                    Operation.PURCHASE, new PurchaseHandler(),
                    Operation.RETURN, new ReturnHandler(),
                    Operation.SUPPLY, new SupplyHandler());

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        return map.get(operation);
    }
}
