package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.models.FruitTransaction;

public class ShopReturn implements ShopActivities {
    @Override
    public void updateStorageData(FruitTransaction transition) {
        if (FruitStorage.fruits.containsKey(transition.getFruitType())) {
            int oldAmount = FruitStorage.fruits.get(transition.getFruitType());
            int newAmount = oldAmount + transition.getFruitAmount();
            FruitStorage.fruits.put(transition.getFruitType(), newAmount);
        } else {
            FruitStorage.fruits.put(transition.getFruitType(), transition.getFruitAmount());
        }
    }
}
