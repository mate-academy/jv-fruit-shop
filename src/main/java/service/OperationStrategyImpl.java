package service;

import java.util.Map;
import model.FruitRecordDto;
import service.type.service.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitRecordDto.Activities, OperationHandler> mapTypeHandler;

    public OperationStrategyImpl(Map<FruitRecordDto.Activities, OperationHandler> mapTypeHandler) {
        this.mapTypeHandler = mapTypeHandler;
    }

    @Override
    public OperationHandler getHandler(FruitRecordDto.Activities type) {
        return mapTypeHandler.get(type);
    }
}
