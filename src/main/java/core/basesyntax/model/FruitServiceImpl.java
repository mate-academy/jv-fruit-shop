package core.basesyntax.model;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.strategy.FruitOperationHandler;

import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public void save(List<FruitRecordDto> recordDtos, Map<Operation, FruitOperationHandler> operationStrategyMap) {
        for (FruitRecordDto fruitRecordDto : recordDtos) { // b,banana,100
            FruitOperationHandler fruitOperationHandler = operationStrategyMap.get(fruitRecordDto.getOperationType());//отримую операцію
            fruitOperationHandler.apply(fruitRecordDto);
        }
    }

    @Override
    public String getReport() {
        StringBuilder builderReport = new StringBuilder();
        builderReport.append("fruit,quantity").append(System.lineSeparator());

        for (Map.Entry<Fruit, Integer> entry : Storage.fruitsDataBase.entrySet()) {
            builderReport.append(entry.getKey()).append(",").append(entry.getValue()).append(System.lineSeparator());
        }
        return builderReport.toString().strip();
    }
}
