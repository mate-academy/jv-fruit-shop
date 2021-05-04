package core.basesyntax.model;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.strategy.FruitOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public void save(List<FruitRecordDto> recordDto, Map<Operation,
            FruitOperationHandler> operationStrategyMap) {
        for (FruitRecordDto fruitRecordDto : recordDto) {
            FruitOperationHandler fruitOperationHandler
                    = operationStrategyMap.get(fruitRecordDto.getOperationType());
            fruitOperationHandler.apply(fruitRecordDto);
        }
    }

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit, quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitsDataBase.entrySet()) {
            builder.append(entry.getKey()).append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
