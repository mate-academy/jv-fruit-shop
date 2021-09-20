package service;

import java.util.Map;
import model.FruitRecordDto;
import service.type.service.TypeHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitRecordDto.Activities, TypeHandler> mapTypeHandler;

    public OperationStrategyImpl(Map<FruitRecordDto.Activities, TypeHandler> mapTypeHandler) {
        this.mapTypeHandler = mapTypeHandler;
    }

    @Override
    public TypeHandler get(FruitRecordDto.Activities type) {
        return mapTypeHandler.get(type);
    }
}
