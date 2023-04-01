package core.basesyntax.service.impl;

import core.basesyntax.enums.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final int START_INDEX = 3;
    private static final String BRACKETS_REGEX = "\\[|\\]";
    private static final String COMA_REGEX = ",";
    private static final String SPACE_REGEX = " ";
    private OperationStrategy operationStrategy;

    public CreateReportServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public String createReport(String dataFromFile) {
        Map<String, Integer> fruitsMap = new HashMap<>();

        String newLineString = Arrays.toString(dataFromFile.split(System.lineSeparator()));
        newLineString = newLineString.replaceAll(BRACKETS_REGEX, "");

        String[] comaSplitArray = newLineString.split(COMA_REGEX);

        FruitTransaction fruitModel;

        for (int i = START_INDEX; i < comaSplitArray.length; i += 3) {
            comaSplitArray[i] = comaSplitArray[i].replaceAll(SPACE_REGEX, "");
            fruitModel = new FruitTransaction(Operation.fromString(comaSplitArray[i]),
                    comaSplitArray[i + 1],
                    Integer.parseInt(comaSplitArray[i + 2]));
            if (fruitsMap.containsKey(comaSplitArray[i + 1])) {
                fruitsMap.put(fruitModel.getFruit(), operationStrategy
                                .get(fruitModel.getOperation().getOperation())
                        .calculateValueByOperation(fruitModel)
                );
            } else {
                fruitsMap.put(fruitModel.getFruit(), operationStrategy
                        .get(fruitModel.getOperation().getOperation())
                        .calculateValueByOperation(fruitModel)
                );
            }
        }

        return mapToValidString(fruitsMap);
    }

    private String mapToValidString(Map<String, Integer> map) {
        StringBuilder validStringData = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            validStringData.append(entry.getKey() + ",");
            validStringData.append(entry.getValue() + System.lineSeparator());
        }

        return validStringData.toString();
    }
}
