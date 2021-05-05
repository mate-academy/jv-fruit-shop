package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Operation;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String TITLE = "fruit,quantity";

    private final Map<OperationType, Operation> handlersOperation;

    public FruitServiceImpl(Map<OperationType, Operation> handlersOperation) {
        this.handlersOperation = handlersOperation;
    }

    @Override
    public void saveData(List<FruitRecordDto> recordDtos) {
        for (FruitRecordDto dto : recordDtos) {
            handlersOperation.get(dto.getOperationType()).apply(dto);
        }
    }

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE).append(System.lineSeparator());

        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            reportBuilder.append(entry.getKey().getType())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
