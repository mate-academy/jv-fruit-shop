package service;

public class OperationStrategy {
    public OperationService getOperationService(String service) {
        switch (service) {
            case "b" :
                return new BalanceService();
            case "s" :
                return new SupplyService();
            case "p" :
                return new PurchaseService();
            case "r" :
                return new ReturnService();
            default:
                throw new IllegalArgumentException("Unknown service type " + service);
        }
    }
}
