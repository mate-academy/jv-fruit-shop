package service;

import model.dto.FruitRecordDto;

public interface OperationStrategy {
    void operation(FruitRecordDto fruitRecordDto);
}
