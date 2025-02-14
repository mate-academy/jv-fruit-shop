package core.basesyntax;

import core.basesyntax.impl.BalanceOperation;
import core.basesyntax.impl.PurchaseOperation;
import core.basesyntax.impl.ReturnOperation;
import core.basesyntax.impl.SupplyOperation;

public class OperationStrategy {
    public OperationHandler getOperation(String operationType) {
        return switch (operationType) {
            case "b" -> new BalanceOperation();
            case "r" -> new ReturnOperation();
            case "s" -> new SupplyOperation();
            case "p" -> new PurchaseOperation();
            default -> throw new IllegalStateException("Unexpected value: " + operationType);
        };
    }
}
