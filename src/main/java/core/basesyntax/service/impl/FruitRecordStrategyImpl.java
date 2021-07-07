package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FruitRecordStrategy;
import core.basesyntax.service.handler.RecordHandler;
import java.util.Map;

public class FruitRecordStrategyImpl implements FruitRecordStrategy {
    private Map<FruitRecordDto.Type, RecordHandler> activitiesHandleMap;

    public FruitRecordStrategyImpl(Map<FruitRecordDto.Type, RecordHandler> activitiesHandleMap) {
        this.activitiesHandleMap = activitiesHandleMap;
    }

    @Override
    public RecordHandler get(FruitRecordDto.Type type) {
        return activitiesHandleMap.get(type);
    }
}
