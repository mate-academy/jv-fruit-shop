package service.impl;

import db.Storage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ReportService;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMNS_TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private OperationStrategy operationStrategy;

    public ReportServiceImpl() {
        operationStrategy = new OperationStrategyImpl();
    }

    @Override
    public HashMap<String, Integer> createReportToStoreDB() {
        List<FruitTransaction> initialReportFromDB = new ArrayList<>(Storage.FRUIT_TRANSACTIONS);
        HashMap<String, Integer> finalReportToStoreDB = new HashMap<>();
        FruitTransaction fruitTransaction;
        for (int i = 0; i < initialReportFromDB.size(); i++) {
            fruitTransaction = initialReportFromDB.get(i);
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            finalReportToStoreDB.putAll(operationHandler
                    .getCurrentBalanceByFruit(initialReportFromDB, i));
        }
        return finalReportToStoreDB;
    }

    @Override
    public String getReportStringForWriting(HashMap<String, Integer> storedCurrentFriutBalance) {
        StringBuilder summaryStringReport = new StringBuilder(COLUMNS_TITLE);
        String stringReport = storedCurrentFriutBalance.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .sorted()
                .collect(Collectors.joining(LINE_SEPARATOR));
        return summaryStringReport.append(LINE_SEPARATOR).append(stringReport).toString();
    }
}
