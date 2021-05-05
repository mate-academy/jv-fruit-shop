package service;

import model.dto.FruitRecordDto;

public interface OperationHandler {
    int apply(FruitRecordDto fruitRecordDto);
}
