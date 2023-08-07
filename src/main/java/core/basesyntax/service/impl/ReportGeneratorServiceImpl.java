package core.basesyntax.service.impl;

import static core.basesyntax.Main.operationHandlerMap;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportGeneratorService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private final OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);

    public String generateReport(List<String> dataArray) {
        if (dataArray.isEmpty()) {
            throw new IllegalArgumentException("Report generation is not possible:"
                    +
                    " data list is empty.");
        }
        Set<String> fruits = getFruits(dataArray);
        StringBuilder builder = new StringBuilder();
        for (String fruit : fruits) {
            int value = dataArray.stream()
                    .filter(data -> data.split(",")[FRUIT_INDEX].equals(fruit))
                    .mapToInt(data -> {
                        String[] splitDataArray = data.split(",");
                        return strategy
                                .getOperationService(splitDataArray[OPERATION_INDEX])
                                .getValueByOperation(splitDataArray);
                    })
                    .sum();
            if (value < 0) {
                throw new IllegalArgumentException("Value: " + value + " for fruit "
                        +
                        fruit + " is invalid!");
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
