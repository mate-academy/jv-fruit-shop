package strategy;

import model.Operation;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler get(Operation operation) {
        switch (operation) {
            case BALANCE:
                return new BalanceOperationStrategy();
            case SUPPLY:
                return new SupplyOperationStrategy();
            case RETURN:
                return new ReturnOperationStrategy();
            case PURCHASE:
                return new PurchaseOperationStrategy();
            default:
                throw new RuntimeException("Operation not found: " + operation);
        }
    }
}
