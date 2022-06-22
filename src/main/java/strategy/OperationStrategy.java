package strategy;

import service.OperationService;
import service.impl.BalanceOperationService;
import service.impl.PurchaseOperationService;
import service.impl.ReturnOperationService;
import service.impl.SupplyOperationService;

public class OperationStrategy {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    public static OperationService getOperationServiceStrategy(String operation) {
        switch (operation) {
            case BALANCE:
                return new BalanceOperationService();
            case SUPPLY:
                return new SupplyOperationService();
            case PURCHASE:
                return new PurchaseOperationService();
            case RETURN:
                return new ReturnOperationService();
            default:
                throw new RuntimeException("Operation: " + operation + " is not supported");
        }
    }
}
