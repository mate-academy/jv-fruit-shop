package core.basesyntax.strategy;

import core.basesyntax.service.AmountService;
import core.basesyntax.service.impl.BalanceAmountService;
import core.basesyntax.service.impl.PurchaseAmountService;
import core.basesyntax.service.impl.ReturnAmountService;
import core.basesyntax.service.impl.SupplyAmountService;

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
