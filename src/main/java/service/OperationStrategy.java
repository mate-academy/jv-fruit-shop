package service;

import model.FruitRecordDto;
import service.type.service.TypeHandler;

public interface OperationStrategy {
    TypeHandler getHandler(FruitRecordDto.Activities type);
}
