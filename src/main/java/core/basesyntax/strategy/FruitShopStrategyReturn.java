package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class FruitShopStrategyReturn implements FruitShopStrategy {
    @Override
    public void calculate(String fruit, int value) {
        Integer fruitsQuantity = Storage.getFruitsStorage().get(fruit);
        Storage.getFruitsStorage().put(fruit, fruitsQuantity + value);
    }
}
