package core.basesyntax.service.impl;

import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.ReturnHandler;
import core.basesyntax.handlers.SupplyHandler;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReceiveHandler;

public class ReceiveHandlerImpl implements ReceiveHandler {
    @Override
    public OperationHandler getHandler(Operation operation) {
        switch (operation) {
            case BALANCE:
                return new BalanceHandler();
            case PURCHASE:
                return new PurchaseHandler();
            case RETURN:
                return new ReturnHandler();
            case SUPPLY:
                return new SupplyHandler();
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
}
