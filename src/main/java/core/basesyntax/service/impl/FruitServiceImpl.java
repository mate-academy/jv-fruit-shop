package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String COLUMNS_NAME = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public void saveData(List<FruitRecordDto> parsedLines,
                         Map<Operation, FruitOperationHandler> operationStrategy) {
        for (FruitRecordDto parsedLine : parsedLines) {
            Operation operationType = parsedLine.getOperationType();
            operationStrategy.get(operationType).applyOperation(parsedLine);
        }
    }

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(COLUMNS_NAME).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            reportBuilder.append(entry.getKey().getFruitName())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
