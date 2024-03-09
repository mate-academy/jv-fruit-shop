package core.basesyntax.strategy.impl;

import core.basesyntax.service.RecordMapper;
import core.basesyntax.strategy.RecordMapperStrategy;
import java.util.Map;

public class RecordMapperStrategyImpl implements RecordMapperStrategy {
    private final Map<String, RecordMapper> recordMappers;

    public RecordMapperStrategyImpl(Map<String, RecordMapper> recordMappers) {
        this.recordMappers = recordMappers;
    }

    @Override
    public RecordMapper get(String productType) {
        return recordMappers.get(productType);
    }
}
