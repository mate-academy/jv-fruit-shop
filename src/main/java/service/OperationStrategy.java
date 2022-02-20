package service;

import model.FruitRecordDto;
import service.type.service.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(FruitRecordDto.Activities type);
}
