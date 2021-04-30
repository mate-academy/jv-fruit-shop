package core.basesyntax.storage.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.fruit.dto.FruitDto;
import java.util.Map;

public class TakeFromStorageHandlerImpl implements StorageHandler {
    @Override
    public void handleGoods(FruitDto fruitData) {
        int amount = fruitData.getAmount();
        String fruitType = fruitData.getFruitType();
        Map<String, Integer> fruitStorage = Storage.getFruitStorage();
        if (fruitStorage.get(fruitType) != null
                && fruitStorage.get(fruitType) - amount < 0) {
            throw new RuntimeException("Buyers will not be able to buy " + amount + " "
                    + fruitType + " because there are only "
                    + fruitStorage.get(fruitType) + " units in stock");
        }
        if (!fruitStorage.containsKey(fruitType)) {
            throw new RuntimeException("There is no such fruit in the stock: " + fruitType + ".");
        }
        fruitStorage.put(fruitType, fruitStorage.get(fruitType) - amount);
    }
}

