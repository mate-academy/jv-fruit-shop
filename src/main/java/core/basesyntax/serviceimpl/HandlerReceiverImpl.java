package core.basesyntax.serviceimpl;

import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.HandlerReceiver;

public class HandlerReceiverImpl implements HandlerReceiver {
    @Override
    public OperationHandler getHandler(String operation) {
        switch (operation) {
            case "b":
                return new BalanceOperation();
            case "s":
                return new SupplyOperation();
            case "r":
                return new ReturnOperation();
            case "p":
                return new PurchaseOperation();
            default:
                throw new RuntimeException("Invalid operation " + operation);
        }
    }
}
