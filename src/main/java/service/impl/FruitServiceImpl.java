package service.impl;

import java.util.List;
import model.dto.FruitRecordDto;
import service.FruitService;
import service.FruitStrategy;

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
