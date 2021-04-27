package core.basesyntax.managing.storage;

import java.util.Map;

public class AddToStorageImp implements HandleGoods {
    @Override
    public void handleGoods(Map<String, Integer> storage, String fruitType, Integer amount) {
        if (amount < 0) {
            throw new RuntimeException("Buyers will not be able to buy " + amount
                    + " " + fruitType + ". " + amount + " is incorrect input.");
        }
        if (storage.containsKey(fruitType)) {
            storage.put(fruitType, storage.get(fruitType) + amount);
        } else {
            storage.put(fruitType, amount);
        }
    }
}
