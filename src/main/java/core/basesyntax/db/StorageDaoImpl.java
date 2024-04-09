package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruitTransactions.add(fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruitName) {
        return Storage.fruitTransactions.stream()
                .filter(f -> f.getFruit().equals(fruitName))
                .findFirst().orElse(null);
    }
}
