package core.basesyntax.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.GenerateReport;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class GenerateReportImpl implements GenerateReport {
    private static final String TITLE_FRUIT = "fruit";
    private static final String SEPARATOR = ",";
    private static final String TITLE_QUANTITY = "quantity";
    private static final Integer OPERATION_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer QUANTITY_INDEX = 2;
    private OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public String generateReportString(Map<String, Integer> fruits) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE_FRUIT).append(SEPARATOR).append(TITLE_QUANTITY);
        for (Map.Entry<String, Integer> fruit : fruits.entrySet()) {
            reportBuilder.append(System.lineSeparator());
            reportBuilder.append(fruit.getKey()).append(SEPARATOR).append(fruit.getValue());
        }
        return reportBuilder.toString();
    }

    @Override
    public void generateReport(List<String[]> data) {
        for (String[] item : data) {
            operationStrategy.get(Operation.getByCode(item[OPERATION_INDEX]))
                    .apply(item[FRUIT_INDEX], Integer.parseInt(item[QUANTITY_INDEX]));
        }
    }
}
