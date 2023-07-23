package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportCreatorService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService<FruitTransaction> {
    @Override
    public String create(List<FruitTransaction> fruitTransactions) {
        checkFruitTransactionsForNull(fruitTransactions);
        Set<String> fruitsSet = getAllFruitsNames(fruitTransactions);
        Map<String, Integer> report = createMapWithFruitsAsKey(fruitsSet);
        fillReport(fruitTransactions, report);
        return convertMapToString(report);
    }

    private void checkFruitTransactionsForNull(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions == null) {
            throw new RuntimeException("The input list of fruit transactions is null!");
        }
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
            checkQuantityForNotPositiveNumber(quantity);
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
        report.forEach((key, value) -> {
            if (value < 0) {
                throw new RuntimeException("Final amount of fruits \""
                        + key + "\" is "
                        + value + "! The number can't be negative");
            }
        });
    }

    private void checkQuantityForNotPositiveNumber(int quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Quantity in a transaction should be above zero, but input "
                    + "quantity is " + quantity);
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
