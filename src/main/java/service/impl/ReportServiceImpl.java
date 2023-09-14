package service.impl;

import database.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Transaction;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String WORDS_SEPARATOR = ",";
    private static final String NEW_LINE = "\n";
    private static final String HEAD_OF_FILE = "fruit,quantity\n";

    @Override
    public void createReport(List<Transaction> transactionServiceList) {
        for (Transaction transactionService : transactionServiceList) {
            String fruit = transactionService.getFruitName();
            int value = transactionService.getFruitValue();
            transactionService.getFruitOperationType()
                    .doTransaction(fruit, value);
        }
    }

    public List<String> getReportList() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> linesList = new ArrayList<>();
        stringBuilder.append(HEAD_OF_FILE);
        for (Map.Entry<String, Integer> entry : Storage.STORAGE.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(WORDS_SEPARATOR)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        linesList.add(stringBuilder.toString());
        return linesList;
    }
}
