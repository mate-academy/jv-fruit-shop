package fruite.store.service.strategy;

public class StrategyType {
    public void doSpecialOperationOnFruits(String type, String fruit, String quantity) {
        Integer intQuantity = Integer.parseInt(quantity);
        switch (type) {
            case "b":
                OperationType balanceOperationType = new BalanceOperationType();
                balanceOperationType.doOpearation(fruit, intQuantity);
                break;
            case "s":
                OperationType supplyOperationType = new SupplyOperationType();
                supplyOperationType.doOpearation(fruit, intQuantity);
                break;
            case "p":
                OperationType purchaseOperationType = new PurchaseOperationType();
                purchaseOperationType.doOpearation(fruit, intQuantity);
                break;
            case "r":
                OperationType returnOperationType = new ReturnOperationType();
                returnOperationType.doOpearation(fruit, intQuantity);
                break;
            default:
                throw new RuntimeException("Unknown operation");
        }
    }
}
