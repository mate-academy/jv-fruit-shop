package core.basesyntax.strategy.filestrategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.strategy.filestrategy.ReportBuilder;
import core.basesyntax.strategy.operationstrategy.OperationCalculator;
import core.basesyntax.strategy.operationstrategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReportBuilderImpl implements ReportBuilder {
    private static final String HEADER = "fruit,quantity";
    private static final String DATA_SEPARATOR = ",";
    private final OperationStrategy operationStrategy;

    public CsvReportBuilderImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

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
            Operation operation = transaction.getOperation();
            OperationCalculator calculator = operationStrategy.getOperationCalculator(operation);
            String fruitName = transaction.getFruit();
            int operationQuantity = transaction.getQuantity();
            int currentQuantity = operation == Operation.BALANCE ? 0 : dataMap.get(fruitName);
            int newAmount = calculator.calculate(currentQuantity, operationQuantity);
            dataMap.put(fruitName, newAmount);
        }
        return dataMap;
    }
}
