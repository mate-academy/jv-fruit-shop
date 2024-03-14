package core.basesyntax.strategy.impl;

import core.basesyntax.service.RecordMapper;
import core.basesyntax.strategy.RecordMapperStrategy;
import java.util.Map;

public class RecordMapperStrategyImpl implements RecordMapperStrategy {
    private static Map<String, RecordMapper> recordMappers;

    public RecordMapperStrategyImpl() {
    }

    public RecordMapperStrategyImpl(Map<String, RecordMapper> recordMappers) {
        RecordMapperStrategyImpl.recordMappers = recordMappers;
    }

    @Override
    public RecordMapper get(String productType) {
        return recordMappers.get(productType);
    }
}
