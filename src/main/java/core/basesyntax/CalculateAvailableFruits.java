package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.provider.StrategyProvider;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateAvailableFruits extends ReportGenerator {
    private static final String DESCRIPTION_ROW = "fruit,quantity";
    private final StrategyProvider strategyProvider;

    public CalculateAvailableFruits(StrategyProvider strategyProvider) {
        this.strategyProvider = strategyProvider;
    }

    @Override
    public String generate(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Failed to calculate available fruits."
                    + " The income data is null");
        }

        Map<String, Integer> storage = new HashMap<>();

        for (FruitTransaction transaction : transactions) {
            OperationStrategy operationStrategy
                    = this.strategyProvider.get(transaction.operation());
            String fruit = transaction.fruit();
            int qty = storage.getOrDefault(fruit, 0);
            int newQty = operationStrategy.process(qty, transaction.quantity());

            if (newQty < 0) {
                throw new RuntimeException("Not enough " + fruit
                        + " in storage. Requested " + transaction.quantity()
                        + ", available " + qty);
            }

            storage.put(fruit, newQty);
        }

        String report = storage.entrySet().stream()
                .map(this::formatEntry)
                .collect(Collectors.joining(System.lineSeparator()));

        return DESCRIPTION_ROW + System.lineSeparator() + report;
    }

    private String formatEntry(Map.Entry<String, Integer> entry) {
        return entry.getKey() + "," + entry.getValue();
    }
}
