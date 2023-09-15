package core.basesyntax.strategy;

import core.basesyntax.model.OperationType;
import core.basesyntax.strategy.impl.BalanceOperationsHandler;
import core.basesyntax.strategy.impl.PurchaseOperationsHandler;
import core.basesyntax.strategy.impl.ReturnOperationsHandler;
import core.basesyntax.strategy.impl.SupplyOperationsHandler;

public class OperationsStrategy {
    public OperationsHandler getOperationsHandler(String operationsCode) {
        if (operationsCode.equals(OperationType.BALANCE.getCode())) {
            return new BalanceOperationsHandler();
        }
        if (operationsCode.equals(OperationType.SUPPLY.getCode())) {
            return new SupplyOperationsHandler();
        }
        if (operationsCode.equals(OperationType.PURCHASE.getCode())) {
            return new PurchaseOperationsHandler();
        }
        if (operationsCode.equals(OperationType.RETURN.getCode())) {
            return new ReturnOperationsHandler();
        }
        return null;
    }
}
