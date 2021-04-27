package core.basesyntax.managing.storage;

import java.util.Map;

public class TakeFromStorageImpl implements HandleGoods {
    @Override
    public void handleGoods(Map<String, Integer> storage, String fruitType, Integer amount) {
        if (amount < 0) {
            throw new RuntimeException("Buyers will not be able to buy "
                    + amount + " " + fruitType + ". "
                    + amount + " is incorrect input.");
        }
        if (storage.containsKey(fruitType) && storage.get(fruitType) - amount >= 0) {
            storage.put(fruitType, storage.get(fruitType) - amount);
        } else {
            throw new RuntimeException("Buyers will not be able to buy " + amount + " "
                    + fruitType + " because there are only "
                    + storage.get(fruitType) + " units in stock");
        }
    }
}
