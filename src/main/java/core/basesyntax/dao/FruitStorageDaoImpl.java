package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Set;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public void add(String fruit, int quantity) {
        FruitStorage.getFruitStorage().put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return FruitStorage.getFruitStorage().get(fruit);
    }

    @Override
    public Set<String> getFruitSet() {
        return FruitStorage.getFruitStorage().keySet();
    }
}
