package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.operation.BalanceHandlerImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandlerImpl;
import core.basesyntax.service.operation.ReturnHandlerImpl;
import core.basesyntax.service.operation.SupplyHandlerImpl;

public class TransactionStrategy {
    public OperationHandler getOperationHandler(Operation operation) {
        switch (operation) {
            case BALANCE:
                return new BalanceHandlerImpl();
            case SUPPLY:
                return new SupplyHandlerImpl();
            case PURCHASE:
                return new PurchaseHandlerImpl();
            case RETURN:
                return new ReturnHandlerImpl();
            default:
                throw new RuntimeException("No such operation");
        }
    }
}
