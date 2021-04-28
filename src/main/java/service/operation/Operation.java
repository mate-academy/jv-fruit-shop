package service.operation;

import model.FruitRecordDto;

public interface Operation {
    boolean apply(FruitRecordDto fruitRecordDto);
}
