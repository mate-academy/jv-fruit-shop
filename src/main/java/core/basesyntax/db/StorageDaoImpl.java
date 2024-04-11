package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getFruit().equals(fruitName))
                .findFirst().orElse(null);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.fruits;
    }
}
