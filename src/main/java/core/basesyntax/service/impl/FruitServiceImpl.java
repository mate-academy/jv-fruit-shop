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
    private static final String CSV_SEPARATOR = ",";
    private Map<Operation, FruitOperationHandler> operations;

    public FruitServiceImpl(Map<Operation, FruitOperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public void saveData(List<FruitRecordDto> parsedLines) {
        for (FruitRecordDto parsedLine : parsedLines) {
            Operation operationType = parsedLine.getOperationType();
            operations.get(operationType).applyOperation(parsedLine);
        }
    }

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(COLUMNS_NAME).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            reportBuilder.append(entry.getKey().getFruitName())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
