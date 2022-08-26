package core.basesyntax.strategy;

import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler get(String operation) {
        switch (operation) {
            case "p":
                return new PurchaseOperationHandler();
            case "r":
                return new ReturnOperationHandler();
            case "s":
                return new SupplyOperationHandler();
            default:
                return new BalanceOperationHandler();
        }
    }
}
