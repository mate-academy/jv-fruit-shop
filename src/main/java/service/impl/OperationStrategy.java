package service.impl;

import model.Operation;
import service.OperationService;

public class OperationStrategy {
    private static final String BALANCE = "b";
    private static final String RETURN = "r";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";

    public OperationService getOperationService(Operation operation) {
        return switch (operation.getCode()) {
            case BALANCE -> new BalanceService();
            case RETURN -> new ReturnOperationService();
            case SUPPLY -> new SupplyOperationService();
            case PURCHASE -> new PurchaseOperationService();
            default -> throw new IllegalStateException(
                    "Unknown operation: " + operation.getCode());
        };
    }
}
