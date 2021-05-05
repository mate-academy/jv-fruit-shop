package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface StrategyOperation {
    Map<Fruit, Integer> get(List<FruitRecordDto> fruitRecordDtos);

}
