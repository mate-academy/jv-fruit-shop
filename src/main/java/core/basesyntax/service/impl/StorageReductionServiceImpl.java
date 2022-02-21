package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDto;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class StorageReductionServiceImpl implements StorageService {
    @Override
    public void actionToStorage(FruitDto transactionLog, Map<Fruit, Integer> storageMap) {
        for (Map.Entry<Fruit, Integer> fruitItem : storageMap.entrySet()) {
            if (fruitItem.getKey().getName().equals(transactionLog.getFruitName())) {
                int oldValue = storageMap.get(fruitItem.getKey());
                if (oldValue >= transactionLog.getFruitQuantity()) {
                    storageMap.replace(fruitItem.getKey(),
                            oldValue - transactionLog.getFruitQuantity());
                } else {
                    throw new RuntimeException("Not enough " + fruitItem.getKey().getName()
                            + "s in the storage");
                }
            }
        }
    }
}
