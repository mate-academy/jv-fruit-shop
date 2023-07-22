package core.basesyntax.service.impl;

import core.basesyntax.db.FruitTransactionsStorage;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportCreatorService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService<FruitTransaction> {
    @Override
    public String create(List<FruitTransaction> fruitTransactions) {
        Set<String> fruitsSet = getAllFruitsNames(fruitTransactions);
        Map<String, Integer> report = createMapWithFruitsAsKey(fruitsSet);
        fillReport(fruitTransactions, report);
        return convertMapToString(report);
    }

    private Set<String> getAllFruitsNames(List<FruitTransaction> fruitTransactions) {
        return fruitTransactions.stream()
                .map(FruitTransaction::getFruit)
                .collect(Collectors.toSet());
    }

    private Map<String, Integer> createMapWithFruitsAsKey(Set<String> fruitsSet) {
        return fruitsSet.stream().collect(Collectors.toMap(s -> s, i -> 0));
    }

    private void fillReport(List<FruitTransaction> fruitTransactions, Map<String, Integer> report) {
        checkReportForNull(report);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            FruitTransaction.Operation operation = fruitTransaction.getOperation();
            String fruit = fruitTransaction.getFruit();
            int quantity = fruitTransaction.getQuantity();
            int changedAmountOfCurrentFruit = 0;
            switch (operation) {
                case RETURN:
                case SUPPLY:
                    changedAmountOfCurrentFruit = report.get(fruit) + quantity;
                    break;
                case PURCHASE:
                    changedAmountOfCurrentFruit = report.get(fruit) - quantity;
                    break;
                case BALANCE:
                    changedAmountOfCurrentFruit = quantity;
                    break;
                default:
                    throw new RuntimeException("There is no operations with input type "
                            + operation);
            }
            report.replace(fruit, changedAmountOfCurrentFruit);
        }
    }

    private void checkReportForNull(Map<String, Integer> report) {
        if (report == null) {
            throw new RuntimeException("The input list is null((");
        }
    }

    private String convertMapToString(Map<String, Integer> mapReport) {
        StringBuilder stringBuilderReport = new StringBuilder();
        for (var entry : mapReport.entrySet()) {
            stringBuilderReport.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilderReport.toString();
    }
}
