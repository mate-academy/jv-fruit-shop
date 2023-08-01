package core.basesyntax.operationstrategy;

import core.basesyntax.exceptions.OperationNotFoundException;
import core.basesyntax.operationstrategy.handler.BalanceOperationHandler;
import core.basesyntax.operationstrategy.handler.OperationHandler;
import core.basesyntax.operationstrategy.handler.PurchaseOperationHandler;
import core.basesyntax.operationstrategy.handler.ReturnOperationHandler;
import core.basesyntax.operationstrategy.handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> strategy = new HashMap<>();

    public OperationStrategyImpl() {
        strategy.put(Operation.BALANCE, new BalanceOperationHandler());
        strategy.put(Operation.RETURN, new ReturnOperationHandler());
        strategy.put(Operation.PURCHASE, new PurchaseOperationHandler());
        strategy.put(Operation.SUPPLY, new SupplyOperationHandler());
    }

    @Override
    public OperationHandler getOperationHandler(Operation operation) {
        if (strategy.get(operation) == null) {
            throw new OperationNotFoundException("Strategy with for operation: "
                    + operation + " not found");
        }
        return strategy.get(operation);
    }
}
