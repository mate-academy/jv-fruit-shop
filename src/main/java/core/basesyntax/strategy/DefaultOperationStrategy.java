package core.basesyntax.strategy;

import core.basesyntax.Operation;
import core.basesyntax.operationHandler.*;

public class DefaultOperationStrategy implements OperationStrategy{
    @Override
    public OperationHandler getHandler(Operation operation) {
        return switch (operation) {
            case BALANCE -> new BalanceHandler();
            case SUPPLY -> new SupplyHandler();
            case PURCHASE -> new PurchaseHandler();
            case RETURN -> new ReturnHandler();
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
}
