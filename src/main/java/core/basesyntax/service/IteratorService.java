package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDto;
import core.basesyntax.strategy.TransDistrStrategy;
import java.util.List;
import java.util.Map;

public interface IteratorService {
    void iterate(List<FruitDto> transLogs,
                 TransDistrStrategy transDistrStrategy,
                 Map<Fruit, Integer> storageMap);
}
