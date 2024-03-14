package core.basesyntax.strategy;

import core.basesyntax.service.RecordMapper;

public interface RecordMapperStrategy {
    RecordMapper get(String productType);
}
