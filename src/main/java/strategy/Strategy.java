package strategy;

import service.BalanceService;
import service.OperationHandler;
import service.PurchaseService;
import service.ReturnService;
import service.SupplyService;

public class Strategy {
    public OperationHandler getOperationValue(String operationValue) {
        Operation operation = Operation.fromString(operationValue);
        return switch (operation) {
            case BALANCE -> new BalanceService();
            case SUPPLY -> new SupplyService();
            case PURCHASE -> new PurchaseService();
            case RETURN -> new ReturnService();
        };
    }
}
