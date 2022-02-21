package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDto;
import java.util.Map;

public interface StorageService {
    void actionToStorage(FruitDto fruitDto, Map<Fruit, Integer> storageMap);
}
