package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.models.FruitTransaction;

public class ShopPurchase implements ShopActivities {
    @Override
    public void updateStorageData(FruitTransaction transition) {
        if (FruitStorage.fruits.containsKey(transition.getFruitType())) {
            int amount;
            if (transition.getFruitAmount()
                    < (amount = FruitStorage.fruits.get(transition.getFruitType()))) {
                int newAmount = amount - transition.getFruitAmount();
                FruitStorage.fruits.put(transition.getFruitType(), newAmount);
            } else {
                FruitStorage.fruits.put(transition.getFruitType(), 0);
            }
        } else {
            throw new RuntimeException("We don't have this Fruit Type: "
                    + transition.getFruitType());
        }
    }
}
