package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitDataCounter;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.QuantityCalculationStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitDataCounterImpl implements FruitDataCounter {
    private static final String CHAR_FOR_DATA = ",";

    @Override
    public List<String> fruits(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> fruitMap = new HashMap<>();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            QuantityCalculationStrategy strategy = getStrategy(fruitTransaction.getOperation());
            int quant = strategy.calculate(fruitTransaction.getQuantity());
            fruitMap.merge(fruitTransaction.getFruit(), quant, Integer::sum);
        }
        List<String> fruitLines = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            String result = entry.getKey() + CHAR_FOR_DATA + entry.getValue();
            fruitLines.add(result);
        }
        return fruitLines;
    }

    private QuantityCalculationStrategy getStrategy(FruitTransaction.Operation operation) {
        return switch (operation) {
            case RETURN -> new ReturnStrategy();
            case PURCHASE -> new PurchaseStrategy();
            case SUPPLY -> new SupplyStrategy();
            case BALANCE -> new BalanceStrategy();
            default ->
                    throw new IllegalArgumentException("Unknown operation: "
                            + operation);
        };
    }
}
