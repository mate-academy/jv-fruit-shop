package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.amount.BalanceHandlerImpl;
import core.basesyntax.service.amount.OperationHandler;
import core.basesyntax.service.amount.PurchaseHandlerImpl;
import core.basesyntax.service.amount.ReturnHandlerImpl;
import core.basesyntax.service.amount.SupplyHandlerImpl;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler getOperationImpl(Operation operation) {
        switch (operation) {
            case RETURN:
                return new ReturnHandlerImpl();
            case BALANCE:
                return new BalanceHandlerImpl();
            case PURCHASE:
                return new PurchaseHandlerImpl();
            case SUPPLY:
                return new SupplyHandlerImpl();
            default:
                throw new RuntimeException("Invalid operation " + operation);
        }
    }
}
