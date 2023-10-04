package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class StrategyImplementation {
    private Map<FruitTransaction.Operation, FruitShopOperationsHandler> processSelector;

    public StrategyImplementation(Map<FruitTransaction.Operation,
            FruitShopOperationsHandler> processSelectorMap) {
        processSelector = processSelectorMap;
    }

    public Map<FruitTransaction.Operation, FruitShopOperationsHandler> getProcessSelector() {
        return processSelector;
    }
}
