package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class StrategyImplementation {
    private static final Map<FruitTransaction.Operation, FruitShopOperationsHandler> processSelector
            = new HashMap<>();

    public StrategyImplementation() {
        processSelector.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        processSelector.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        processSelector.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        processSelector.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
    }

    public Map<FruitTransaction.Operation, FruitShopOperationsHandler> getProcessSelector() {
        return processSelector;
    }
}
