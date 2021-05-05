package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String SEPARATOR = ",";

    @Override
    public void addToStorage(List<FruitRecordDto> recordDtos,
                             Map<Operation, FruitOperationHandler> strategyMap) {
        for (FruitRecordDto fruitRecordDto : recordDtos) {
            Operation operationType = fruitRecordDto.getOperation();
            FruitOperationHandler fruitOperation = strategyMap.get(operationType);
            fruitOperation.apply(fruitRecordDto);
        }
    }

    @Override
    public String getReport() {
        StringBuilder stringReport = new StringBuilder(TITLE);
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            stringReport.append(entry.getKey().getName())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringReport.toString();
    }
}
