package core.basesyntax.strategy.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationService;

public class OperationStrategy {
    public OperationService getCertainOperation(Operation operation) {
        switch (operation) {
            case BALANCE: return new BalanceOperation();
            case RETURN: return new ReturnOperation();
            case SUPPLY: return new SupplyOperation();
            case PURCHASE: return new PurchaceOperation();
            default: throw new RuntimeException("Invalid operation: " + operation.name());
        }
    }
}
