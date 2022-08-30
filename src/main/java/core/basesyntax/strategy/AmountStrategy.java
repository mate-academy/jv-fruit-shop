package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.BalanceAmountService;
import core.basesyntax.strategy.impl.PurchaseAmountService;
import core.basesyntax.strategy.impl.ReturnAmountService;
import core.basesyntax.strategy.impl.SupplyAmountService;
import java.util.HashMap;
import java.util.Map;

public class AmountStrategy {
    private Map<String, AmountService> amountServices;

    {
        amountServices = new HashMap<>();
        amountServices.put("b", new BalanceAmountService());
        amountServices.put("s", new SupplyAmountService());
        amountServices.put("p", new PurchaseAmountService());
        amountServices.put("r", new ReturnAmountService());
    }

    public AmountService getAmountService(String operation) {
        return amountServices.get(operation);
    }
}
