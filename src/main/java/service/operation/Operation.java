package service.operation;

import model.FruitRecordDto;

public interface Operation {
    void apply(FruitRecordDto fruitRecordDto);
}
