package core.basesyntax.service;

import core.basesyntax.model.FruitDto;
import core.basesyntax.strategy.StorageUpdaterStrategy;
import java.util.List;

public class FruitStorageUpdater {

    public void updateStock(List<FruitDto> fruitDtos) {
        for (FruitDto fruitDto : fruitDtos) {
            StorageUpdaterStrategy storageUpdaterStrategy = new StorageUpdaterStrategy();
            storageUpdaterStrategy.apply(fruitDto);
        }
    }
}
