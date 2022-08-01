package core.basesyntax.daoimpl;

import core.basesyntax.dao.DaoFruitStorage;
import core.basesyntax.storage.FruitsStorage;
import java.util.Map;

public class DaoFruitStorageImpl implements DaoFruitStorage {

    @Override
    public Map<String, Integer> getFromFruitStorage() {
        return FruitsStorage.accessFS();
    }

    @Override
    public Integer getQuantityFromFruitStorage(String fruitType) {
        return FruitsStorage.accessFS().get(fruitType);
    }

    @Override
    public void addToFruitStorage(String fruitType, int quantity) {
        FruitsStorage.accessFS().put(fruitType, quantity);
    }

}
