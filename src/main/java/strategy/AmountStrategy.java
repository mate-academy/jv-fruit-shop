package strategy;

import service.AmountService;
import service.impl.BalanceAmountService;
import service.impl.PurchaseAmountService;
import service.impl.ReturnAmountService;
import service.impl.SupplyAmountService;

public class AmountStrategy {
    public AmountService getAmountService(String operation) {
        switch (operation) {
            case ("b"):
                return new BalanceAmountService();
            case ("s"):
                return new SupplyAmountService();
            case ("p"):
                return new PurchaseAmountService();
            case ("r"):
            default:
                return new ReturnAmountService();
        }
    }
}
