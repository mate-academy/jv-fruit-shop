package Strategy;

import Strategy.impl.BalanceOperationService;
import Strategy.impl.PurchaseOperationService;
import Strategy.impl.ReturnOperationService;
import Strategy.impl.SupplyOperationService;
import model.FruitTransaction;

public class FruitStrategy {
    public OperationService getOperationServiceByOperation(FruitTransaction.Operation operation) {
        return switch (operation) {
            case SUPPLY -> new SupplyOperationService();
            case BALANCE -> new BalanceOperationService();
            case RETURN -> new ReturnOperationService();
            case PURCHASE -> new PurchaseOperationService();
        };
    }

}
