package core.basesyntax.storage.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.fruit.dto.FruitDto;

public class TakeFromStorageImpl implements HandleGoods {

    @Override
    public void handleGoods(FruitDto fruitData) {
        int amount = fruitData.getAmount();
        String fruitType = fruitData.getFruitType();
        if (Storage.getFruitStorage().get(fruitType) != null
                && Storage.getFruitStorage().get(fruitType) - amount < 0) {
            throw new RuntimeException("Buyers will not be able to buy " + amount + " "
                    + fruitType + " because there are only "
                    + Storage.getFruitStorage().get(fruitType) + " units in stock");
        }
        if (!Storage.getFruitStorage().containsKey(fruitType)) {
            throw new RuntimeException("There is no such fruit in the stock: " + fruitType + ".");
        } else {
            Storage.getFruitStorage().put(fruitType,
                    Storage.getFruitStorage().get(fruitType) - amount);
        }
    }
}
