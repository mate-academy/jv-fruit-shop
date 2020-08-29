package core.basesyntax.operations;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.FruitDto;

public class SupplyAndReturnOperation implements StorageOperation {

    @Override
    public void doStorageOperation(FruitDto fruitDto) {
        FruitStorage.fruitStorage.merge(fruitDto.getFruit(),
                fruitDto.getQuantity(),
                Integer::sum);
        FruitStorage.expiration.put(fruitDto.getFruit(), fruitDto.getExpDate());
    }
}
