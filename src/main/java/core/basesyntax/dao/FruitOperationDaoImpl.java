package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import java.util.Optional;

public class FruitOperationDaoImpl implements FruitOperationDao {
    @Override
    public void add(FruitOperation fruitOperation) {
        Storage.SHOP_STORE.add(fruitOperation);
    }

    @Override
    public Optional<FruitOperation> get(String fruit) {
        return Storage.SHOP_STORE.stream()
                .filter(fruitOperation -> fruitOperation.getFruit().equals(fruit))
                .findFirst();
    }

    @Override
    public void update(FruitOperation fruitOperation) {
        Optional<FruitOperation> existing = get(fruitOperation.getFruit());
        existing.ifPresent(Storage.SHOP_STORE::remove);
        add(fruitOperation);
    }
}
