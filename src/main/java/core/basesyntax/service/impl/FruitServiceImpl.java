package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private FruitStrategy fruitStrategy;

    public FruitServiceImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void saveDto(List<FruitRecordDto> dtos) {
        for (FruitRecordDto dto : dtos) {
            fruitStrategy.get(dto.getOperationType()).apply(dto);
        }
    }
}
