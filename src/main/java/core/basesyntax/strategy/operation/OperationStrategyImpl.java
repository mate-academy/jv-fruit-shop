package core.basesyntax.strategy.operation;

import core.basesyntax.model.Operation;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler get(final Operation operation) {
        switch (operation) {
            case BALANCE:
                return new BalanceImpl();
            case SUPPLY:
                return new SupplyImpl();
            case PURCHASE:
                return new PurchaseImpl();
            case RETURN:
                return new ReturnImpl();
            default:
                throw new RuntimeException(UNKNOWN_OPERATION);
        }
    }
}
