package core.basesyntax.service.implementions;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<OperationType, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<OperationType, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public boolean saveDataToDataBase(List<FruitRecordDto> fruitRecordDtos) {
        for (FruitRecordDto dto : fruitRecordDtos) {
            operationStrategyMap.get(dto.getOperationType()).apply(dto);
        }
        return true;
    }
}
