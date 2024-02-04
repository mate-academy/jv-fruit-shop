package core.basesyntax.service;

import core.basesyntax.model.FruitTransactionRow;
import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.service.strategy.logic.StrategyMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<FruitResultingRow> generateReport(List<FruitTransactionRow> transactionHistory) {

        Map<String, List<FruitTransactionRow>> transactionsGroupedByFruit = transactionHistory
                .stream()
                .collect(Collectors.groupingBy(FruitTransactionRow::getFruitName));

        List<FruitResultingRow> reportAsResultingRowsArray = new ArrayList<>();
        for (var entry : transactionsGroupedByFruit.entrySet()) {
            int finalNumOfFruit = 0;
            for (FruitTransactionRow fruitTransactionRow : entry.getValue()) {
                finalNumOfFruit = StrategyMap.getInstance().get(fruitTransactionRow.getOperation())
                        .apply(finalNumOfFruit, fruitTransactionRow.getQuantity());
            }
            reportAsResultingRowsArray.add(new FruitResultingRow(entry.getKey(), finalNumOfFruit));
        }
        return reportAsResultingRowsArray;
    }
}
