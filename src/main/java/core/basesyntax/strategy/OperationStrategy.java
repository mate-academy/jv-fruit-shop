package core.basesyntax.strategy;

import core.basesyntax.operation.Operation;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReturnOperation;
import core.basesyntax.service.impl.SupplyOperation;

public class OperationStrategy {
    public static OperationService getOperation(Operation operation) {
        if (operation.getCode().equals(Operation.BALANCE.getCode())) {
            return new BalanceOperation();
        }
        if (operation.getCode().equals(Operation.SUPPLY.getCode())) {
            return new SupplyOperation();
        }
        if (operation.getCode().equals(Operation.PURCHASE.getCode())) {
            return new PurchaseOperation();
        }
        if (operation.getCode().equals(Operation.RETURN.getCode())) {
            return new ReturnOperation();
        }
        throw new RuntimeException("This operation doesn't exist " + operation);
    }
}
