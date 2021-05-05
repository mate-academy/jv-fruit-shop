package core.basesyntax.model;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.strategy.FruitOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String COLUMNS_NAME = "fruit,quantity";
    private static final String COMMA = ",";

    private final Map<Operation, FruitOperationHandler> strategyMap;

    public FruitServiceImpl(Map<Operation, FruitOperationHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void save(List<FruitRecordDto> recordDtos) {
        for (FruitRecordDto fruitRecordDto : recordDtos) {
            Operation operationType = fruitRecordDto.getOperationType();
            FruitOperationHandler fruitOperation = strategyMap.get(operationType);
            fruitOperation.apply(fruitRecordDto);
        }
    }

    @Override
    public String getReport() {
        StringBuilder builderReport = new StringBuilder();
        builderReport.append(COLUMNS_NAME).append(System.lineSeparator());

        for (Map.Entry<Fruit, Integer> entry : Storage.fruitsDataBase.entrySet()) {
            builderReport.append(entry.getKey().getType())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builderReport.toString();
    }
}
