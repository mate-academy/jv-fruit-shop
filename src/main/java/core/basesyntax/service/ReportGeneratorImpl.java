package core.basesyntax.service;

import core.basesyntax.model.FruitTransactionRow;
import core.basesyntax.service.strategy.logic.StrategyMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public Map<String, Integer> calcFruitsLeftAfterTransactions(List<FruitTransactionRow> transactionHistory) {
        Map<String, List<FruitTransactionRow>> transactionsGroupedByFruit = transactionHistory
                .stream()
                .collect(Collectors.groupingBy(FruitTransactionRow::getFruitName));

        var map = StrategyMap.getInstance();
        Map<String, Integer> groupedFruitsFinalQuantity = new HashMap<>();
        for (var entry : transactionsGroupedByFruit.entrySet()) {
            int finalQuantityForFruit = 0;
            for (FruitTransactionRow fruitTransactionRow : entry.getValue()) {
                finalQuantityForFruit = map.get(fruitTransactionRow.getOperation())
                        .apply(finalQuantityForFruit, fruitTransactionRow.getQuantity());
            }
            groupedFruitsFinalQuantity.put(entry.getKey(), finalQuantityForFruit);
        }
        return groupedFruitsFinalQuantity;
    }
}
