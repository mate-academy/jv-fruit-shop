package core.basesyntax.service;

import core.basesyntax.model.FruitResultingRow;
import core.basesyntax.model.FruitTransactionRow;
import core.basesyntax.service.strategy.StrategyService;
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
        StrategyService service = new StrategyService();
        for (var entry : transactionsGroupedByFruit.entrySet()) {
            List<FruitTransactionRow> transactionsOfCertainFruit = entry.getValue();
            int quantity = service.getFinalQuantityOfFruit(transactionsOfCertainFruit);
            var fruitResultingRow = new FruitResultingRow(entry.getKey(), quantity);
            reportAsResultingRowsArray.add(fruitResultingRow);
        }
        return reportAsResultingRowsArray;
    }
}
