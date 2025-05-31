package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import java.util.Optional;

public class FruitOperationDaoImpl implements FruitOperationDao {

    @Override
    public void add(FruitOperation fruitOperation) {
        Storage.SHOP_STORE.put(fruitOperation.getFruit(), fruitOperation);
    }

    @Override
    public Optional<FruitOperation> get(String fruit) {
        return Optional.ofNullable(Storage.SHOP_STORE.get(fruit));
    }

    @Override
    public void update(FruitOperation fruitOperation) {
        Storage.SHOP_STORE.put(fruitOperation.getFruit(), fruitOperation);
    }
}
