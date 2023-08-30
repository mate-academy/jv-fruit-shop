package core.basesyntax.serviceimpl;

import core.basesyntax.service.OperationService;

public class FruitStrategy {
    public OperationService getOperationService(String type) {
        switch (type) {
            case "s":
                return new SupplyReturnOperationService();
            case "r":
                return new SupplyReturnOperationService();
            case "p":
                return new PurchaseOperationService();
            case "b":
            default:
                return new BalanceOperationService();
        }
    }
}
