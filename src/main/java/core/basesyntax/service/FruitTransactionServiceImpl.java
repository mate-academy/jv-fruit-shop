package core.basesyntax.service;

import core.basesyntax.dao.InfoFromFileDao;
import core.basesyntax.dao.InfoFromFileDaoImpl;
import core.basesyntax.model.FruitTransaction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private final InfoFromFileDao infoFromFileDao = new InfoFromFileDaoImpl();

    public Map<String, Integer> getReport(String fileName) {
        List<FruitTransaction> fruitTransactions =
                infoFromFileDao.getAllTransactionsFromFile(fileName);
        Set<String> fruitsSet = getAllFruitsNames(fruitTransactions);
        Map<String, Integer> report = createMapWithFruitsAsKey(fruitsSet);
        fillReport(fruitTransactions, report);
        writeMapInFile(convertMapToString(report));
        return report;
    }

    private String convertMapToString(Map<String, Integer> mapReport) {
        StringBuilder stringBuilderReport = new StringBuilder();
        for (var entry : mapReport.entrySet()) {
            stringBuilderReport.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilderReport.toString();
    }

    private void writeMapInFile(String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.csv"))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report in file((");
        }
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

    private Map<String, Integer> createMapWithFruitsAsKey(Set<String> fruitsSet) {
        return fruitsSet.stream().collect(Collectors.toMap(s -> s, i -> 0));
    }

    private Set<String> getAllFruitsNames(List<FruitTransaction> fruitTransactions) {
        return fruitTransactions.stream()
                .map(FruitTransaction::getFruit)
                .collect(Collectors.toSet());
    }
}
