package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import java.util.NoSuchElementException;

public class FruitOperationDaoImpl implements FruitOperationDao {
    @Override
    public void add(FruitOperation fruitOperation) {
        Storage.SHOP_STORE.add(fruitOperation);
    }

    @Override
    public FruitOperation get(String fruit) {
        return Storage.SHOP_STORE.stream()
                .filter(fruitOperation -> fruitOperation.getFruit().equals(fruit))
                .findFirst()
                .orElseThrow(()
                        -> new NoSuchElementException("Fruit operation not found for: " + fruit));
    }

    @Override
    public void update(FruitOperation fruitOperation) {
        FruitOperation fruitOperationFromDb = get(fruitOperation.getFruit());
        Storage.SHOP_STORE.remove(fruitOperationFromDb);
        add(fruitOperation);
    }
}
