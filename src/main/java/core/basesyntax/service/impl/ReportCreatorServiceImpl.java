package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportCreatorService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService<FruitTransaction> {
    @Override
    public String create(List<FruitTransaction> info) {
        Set<String> fruitsSet = getAllFruitsNames(Storage.fruitTransactions);
        Map<String, Integer> report = createMapWithFruitsAsKey(fruitsSet);
        fillReport(Storage.fruitTransactions, report);
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
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            FruitTransaction.Operation operation = fruitTransaction.getOperation();
            String fruit = fruitTransaction.getFruit();
            int quantity = fruitTransaction.getQuantity();
            switch (operation) {
                case RETURN:
                case SUPPLY:
                    report.replace(fruit, report.get(fruit) + quantity);
                    break;
                case PURCHASE:
                    report.replace(fruit, report.get(fruit) - quantity);
                    break;
                case BALANCE:
                    report.replace(fruit, quantity);
                    break;
            }
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
