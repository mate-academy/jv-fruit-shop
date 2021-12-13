package core.basesyntax.service.implementions;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;
    private final FruitRecordDto fruitRecordDto;

    public FruitServiceImpl(OperationStrategy operationStrategy,
                            FruitRecordDto fruitRecordDto) {
        this.operationStrategy = operationStrategy;
        this.fruitRecordDto = fruitRecordDto;
    }

    @Override
    public void saveData(List<FruitRecordDto> fruitRecordDtos) {
        for (FruitRecordDto dto : fruitRecordDtos) {
            operationStrategy.getHandler(dto.getOperationType()).apply(dto);
        }
    }
}
