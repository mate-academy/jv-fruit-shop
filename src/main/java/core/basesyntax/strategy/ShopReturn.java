package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.models.FruitTransition;

public class ShopReturn implements ShopActivities {
    @Override
    public void updateStorageData(FruitTransition transition) {
        if (FruitStorage.fruits.containsKey(transition.getFruitType())) {
            int oldAmount = FruitStorage.fruits.get(transition.getFruitType());
            int newAmount = oldAmount + transition.getFruitAmount();
            FruitStorage.fruits.put(transition.getFruitType(), newAmount);
        } else {
            FruitStorage.fruits.put(transition.getFruitType(), transition.getFruitAmount());
        }
    }
}
