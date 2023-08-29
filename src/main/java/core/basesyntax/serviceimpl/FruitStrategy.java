package core.basesyntax.serviceimpl;

import core.basesyntax.service.OperationService;

public class FruitStrategy {
    public OperationService getOperationService(String type){
        switch (type) {
            case "s", "r" : return new SupplyReturnOperationService();
            case "p" : return new PurchaseOperationService();
            case "b" :
            default:
                return new BalanceOperationService();
        }
    }
}
