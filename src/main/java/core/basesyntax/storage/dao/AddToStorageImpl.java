package core.basesyntax.storage.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.fruit.dto.FruitDto;

public class AddToStorageImpl implements HandleGoods {

    @Override
    public void handleGoods(FruitDto fruitData) {
        int amount = fruitData.getAmount();
        String fruitType = fruitData.getFruitType();
        if (Storage.getFruitStorage().containsKey(fruitType)) {
            Storage.getFruitStorage().put(fruitType,
                    Storage.getFruitStorage().get(fruitType) + amount);
        } else {
            Storage.getFruitStorage().put(fruitType, amount);
        }
    }
}
