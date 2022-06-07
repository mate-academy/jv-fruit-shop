package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportServiceCsvImpl implements ReportService {
    private FruitTransactionDao fruitTransactionDao;
    private OperationStrategy operationStrategy;
    private WriterService writerService;

    public ReportServiceCsvImpl(FruitTransactionDao fruitTransactionDao,
                                OperationStrategy operationStrategy) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.operationStrategy = operationStrategy;
        this.writerService = new WriterServiceCsvImpl();
    }

    @Override
    public void writeReport(String reportPath) {
        Map<String, Integer> leftoversMap = fruitsLeftovers(fruitTransactionDao.get());
        StringBuilder report = new StringBuilder()
                .append("fruit,quantity")
                .append(System.lineSeparator())
                .append(mapToString(leftoversMap));
        writerService.write(report.toString(), reportPath);
    }

    private Map<String, Integer> fruitsLeftovers(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitAmount = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            int newQuantity = operationStrategy
                    .get(transaction.getOperation())
                    .getOperationHandler(fruitAmount
                            .getOrDefault(transaction.getFruit(), 0), transaction.getQuantity());
            fruitAmount.put(transaction.getFruit(), newQuantity);
        }
        return fruitAmount;
    }

    private String mapToString(Map<String, Integer> amountFruits) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> amounts : amountFruits.entrySet()) {
            builder.append(amounts.getKey()).append(",")
                    .append(amounts.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
