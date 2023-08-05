package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitShopService {
    void supplyFruit(FruitTransaction transaction);

    void purchaseFruit(FruitTransaction transaction);

    void returnFruit(FruitTransaction transaction);

    int balanceOfFruit(FruitTransaction transaction);
}
