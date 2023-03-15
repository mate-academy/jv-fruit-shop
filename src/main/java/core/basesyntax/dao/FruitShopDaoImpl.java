package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public void add(FruitTransaction fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public FruitTransaction get(FruitTransaction.TYPE type) {
        return Storage.fruits.stream()
                .filter(a -> a.getType().equals(type))
                .findFirst()
                .get();
    }
}
