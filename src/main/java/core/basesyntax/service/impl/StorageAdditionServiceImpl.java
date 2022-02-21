package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDto;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class StorageAdditionServiceImpl implements StorageService {
    @Override
    public void actionToStorage(FruitDto fruitDto, Map<Fruit, Integer> storageMap) {
        for (Map.Entry<Fruit, Integer> fruitItem : storageMap.entrySet()) {
            if (fruitItem.getKey().getName().equals(fruitDto.getFruitName())) {
                int oldValue = storageMap.get(fruitItem.getKey());
                storageMap.replace(fruitItem.getKey(), oldValue + fruitDto.getFruitQuantity());
            }
        }
    }
}
