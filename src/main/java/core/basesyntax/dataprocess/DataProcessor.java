package core.basesyntax.dataprocess;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.BalanceService;
import core.basesyntax.strategy.impl.PurchaseService;
import core.basesyntax.strategy.impl.ReturnService;
import core.basesyntax.strategy.impl.SupplyService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessor {
    private final List<FruitTransaction> fruitTransactions;
    private final Map<String, Integer> fruitData;
    private final Map<String, Strategy> strategyMap;

    public DataProcessor(List<FruitTransaction> fruitTransactions, Map<String, Integer> fruitData) {
        this.fruitTransactions = fruitTransactions;
        this.fruitData = fruitData;
        this.strategyMap = initializeStrategyMap();
    }

    private Map<String, Strategy> initializeStrategyMap() {
        Map<String, Strategy> map = new HashMap<>();
        map.put("b", new BalanceService());
        map.put("s", new SupplyService());
        map.put("p", new PurchaseService());
        map.put("r", new ReturnService());
        return map;
    }

    public void processTransactions() {
        for (FruitTransaction transaction : fruitTransactions) {
            String operation = transaction.getOperation().getCode();
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();

            Strategy strategy = strategyMap.get(operation);
            if (strategy != null) {
                strategy.processData(fruitData, fruit, quantity);
            } else {
                throw new IllegalArgumentException("Unknown operation: " + operation);
            }
        }
    }

    public Map<String, Integer> generateReport() {
        return fruitData;
    }
}
