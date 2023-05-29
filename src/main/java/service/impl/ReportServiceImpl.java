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
    private OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public HashMap<String, Integer> createReportToStoreDB() {
        List<FruitTransaction> initialReportFromDB = new ArrayList<>(Storage.FRUIT_TRANSACTIONS);
        HashMap<String, Integer> finalReportToStoreDB = new HashMap<>();
        FruitTransaction fruitTransaction;
        for (int i = 0; i < initialReportFromDB.size(); i++) {
            fruitTransaction = initialReportFromDB.get(i);
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation().getCode());
            finalReportToStoreDB.putAll(operationHandler
                    .getCurrentBalanceByFruit(initialReportFromDB, i));
        }
        return finalReportToStoreDB;
    }

    @Override
    public String getReportStringForWriting(HashMap<String, Integer> storedCurrentFriutBalance) {
        StringBuilder stringBuilder = new StringBuilder(COLUMNS_TITLE);
        String stringReport = storedCurrentFriutBalance.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .sorted()
                .collect(Collectors.joining(System.lineSeparator()));
        return stringBuilder.append(System.lineSeparator()).append(stringReport).toString();
    }
}
