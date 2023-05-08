package core.basesyntax.service;

import core.basesyntax.db.Storage;

public class FruitServiceImpl implements FruitService {
    @Override
    public void setFruit(String fruit, int quantity) {
        Storage.remnantsOfGoods.put(fruit, quantity);
    }

    @Override
    public void addFruit(String fruit, int toAdd) {
        int amountOfFruitNow = Storage.remnantsOfGoods.get(fruit);
        Storage.remnantsOfGoods.put(fruit, amountOfFruitNow + toAdd);
    }
}
