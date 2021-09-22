package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitRecordsDaoImpl implements FruitRecordsDao {
    @Override
    public void save(Fruit fruit, Integer quantity) {
        FruitStorage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitStorage.fruitStorage;
    }

    @Override
    public int getFruitAmountFromStorage(Fruit fruit) {
        return FruitStorage.fruitStorage.get(fruit);
    }
}
