package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void addFruit(FruitTransaction fruitTransaction) {
        FruitStorage.fruitStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    @Override
    public void increaseQuantity(FruitTransaction fruitTransaction) {
        FruitStorage.fruitStorage.merge(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(), Integer::sum);
    }

    @Override
    public void decreaseQuantity(FruitTransaction fruitTransaction) {
        FruitStorage.fruitStorage.merge(fruitTransaction.getFruit(),
                -fruitTransaction.getQuantity(), Integer::sum);
    }

    @Override
    public Map<String, Integer> getAllAsMap() {
        return new HashMap<>(FruitStorage.fruitStorage);
    }
}
