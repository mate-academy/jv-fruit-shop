package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import java.util.List;
import java.util.Map;

public interface StrategyOperation {
    Map<String, Integer> get(List<FruitRecordDto> fruitRecordDtos);
}
