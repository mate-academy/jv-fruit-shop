package core.basesyntax.service.impl;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGeneratorService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private final OperationStrategy strategy;

    public ReportGeneratorServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public String generateReport(List<String> dataArray) {
        Set<String> fruits = getFruits(dataArray);
        StringBuilder builder = new StringBuilder();
        for (String fruit : fruits) {
            int value = 0;
            for (String data : dataArray) {
                String[] splitDataArray = data.split(",");
                if (splitDataArray[FRUIT_INDEX].equals(fruit)) {
                    value += strategy
                             .getOperationService(splitDataArray[OPERATION_INDEX])
                             .getValueByOperation(splitDataArray);
                }
            }
            builder.append(fruit).append(",").append(value).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    private Set<String> getFruits(List<String> dataArray) {
        return dataArray.stream()
                .map(data -> data.split(",")[FRUIT_INDEX])
                .collect(Collectors.toSet());
    }
}
