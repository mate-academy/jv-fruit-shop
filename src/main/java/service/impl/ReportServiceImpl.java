package service.impl;

import static java.util.stream.Collectors.summingInt;

import db.Storage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";

    public List<String> createReport(List<FruitTransaction> list) {
        Map<String, Integer> fruitTransactions = list.stream()
                .collect(Collectors.groupingBy(
                        FruitTransaction::getFruit, summingInt(fruitTransaction
                                -> new OperationStrategy()
                                .getOperationService(fruitTransaction.getOperation())
                                .operate(fruitTransaction.getQuantity()))));
        for (Map.Entry<String, Integer> entry : fruitTransactions.entrySet()) {
            String newFruitBalance = entry.getKey() + SEPARATOR + entry.getValue();
            Storage.saveToFruitsBalanceReport(newFruitBalance);
        }
        return Storage.getFruitsBalanceReport();
    }
}
