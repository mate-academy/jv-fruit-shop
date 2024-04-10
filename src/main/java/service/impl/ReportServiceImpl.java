package service.impl;

import static java.util.stream.Collectors.summingInt;

import db.Storage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    public Map<String, Integer> createReport(List<String> fruitTransactionsLines) {
        List<FruitTransaction> fruitTransactionsList = new FruitTransactionMapper()
                .map(fruitTransactionsLines);
        Map<String, Integer> fruitTransactions = fruitTransactionsList.stream()
                .collect(Collectors.groupingBy(
                        FruitTransaction::getFruit, summingInt(fruitTransaction
                                -> new OperationStrategy()
                                .getOperationService(fruitTransaction.getOperation())
                                .operate(fruitTransaction.getQuantity()))));
        Storage.saveToFruitsBalanceReport(fruitTransactions);
        return Storage.getFruitsBalanceReport();
    }
}
