package core.basesyntax.service.implementation;

import core.basesyntax.service.CreateReportService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateReportServiceImplementation implements CreateReportService {
    private static final int START_INDEX = 3;
    private OperationStrategy operationStrategy;

    public CreateReportServiceImplementation(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String createReport(String dataFromFile) {
        Map<String, Integer> fruitsMap = new HashMap<>();

        String newLineString = Arrays.toString(dataFromFile.split(System.lineSeparator()));
        newLineString = newLineString.replaceAll("\\[|\\]", "");

        String[] comaSplitArray = newLineString.split(",");

        for (int i = START_INDEX; i < comaSplitArray.length; i += 3) {
            comaSplitArray[i] = comaSplitArray[i].replaceAll(" ", "");
            if (fruitsMap.containsKey(comaSplitArray[i + 1])) {
                fruitsMap.put(comaSplitArray[i + 1], fruitsMap.get(comaSplitArray[i + 1])
                        + operationStrategy.get(comaSplitArray[i])
                        .getValueByOperation(Integer.parseInt(comaSplitArray[i + 2])));
            } else {
                fruitsMap.put(comaSplitArray[i + 1], operationStrategy.get(comaSplitArray[i])
                        .getValueByOperation(Integer.parseInt(comaSplitArray[i + 2])));
            }
        }

        return mapToValidString(fruitsMap);
    }

    private String mapToValidString(Map<String, Integer> map) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey() + ",");
            stringBuilder.append(entry.getValue() + System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
