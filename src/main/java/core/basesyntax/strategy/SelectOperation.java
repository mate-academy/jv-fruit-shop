package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceOperationImpl;
import core.basesyntax.strategy.impl.PurchaseOperationImpl;
import core.basesyntax.strategy.impl.ReturnOperationImpl;
import core.basesyntax.strategy.impl.SupplyOperationImpl;

public class SelectOperation {
    public static OperationsHandler getOperation(String infoLine) {
        switch (infoLine.charAt(0)) {
            case 'b':
                return new BalanceOperationImpl();
            case 's':
                return new SupplyOperationImpl();
            case 'p':
                return new PurchaseOperationImpl();
            case 'r':
                return new ReturnOperationImpl();
            default:
                throw new RuntimeException("Incorrect input");
        }
    }
}
