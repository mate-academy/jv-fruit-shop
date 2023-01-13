package strategy.impl;

import model.FruitTransaction;
import strategy.OperationHandler;
import strategy.OperationStrategy;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler getOperationHandler(FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE:
                return new BalanceOperationHandler();
            case SUPPLY:
                return new SupplyOperationHandler();
            case PURCHASE:
                return new PurchaseOperationHandler();
            case RETURN:
                return new ReturnOperationHandler();
            default:
                throw new RuntimeException("Operation type isn't valid: " + operation);
        }
    }
}
