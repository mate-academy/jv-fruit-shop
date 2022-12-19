package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ReportBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReportBuilderImpl implements ReportBuilder {
    private static final String HEADER = "fruit,quantity";
    private static final String DATA_SEPARATOR = ",";

    @Override
    public String buildReport(List<FruitTransaction> transactions) {
        Map<String, Integer> processedData = processData(transactions);
        StringBuilder reportBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> entry : processedData.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(DATA_SEPARATOR)
                    .append(entry.getValue());
        }
        return reportBuilder.toString();
    }

    private Map<String, Integer> processData(List<FruitTransaction> transactions) {
        Map<String, Integer> dataMap = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            String fruitName = transaction.getFruit();
            int quantity = transaction.getQuantity();
            int newAmount;
            switch (operation) {
                case BALANCE:
                    dataMap.put(fruitName, quantity);
                    break;
                case SUPPLY:
                case RETURN:
                    newAmount = dataMap.get(fruitName) + quantity;
                    dataMap.put(fruitName, newAmount);
                    break;
                case PURCHASE:
                    newAmount = dataMap.get(fruitName) - quantity;
                    dataMap.put(fruitName, newAmount);
                    break;
                default:
                    throw new RuntimeException("Invalid operation type " + operation);
            }
        }
        return dataMap;
    }
}
