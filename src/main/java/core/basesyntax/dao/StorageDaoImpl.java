package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(FruitTransaction fruit) {
        if (fruit != null) {
            Storage.getDataStorage().add(fruit);
            return;
        }
        throw new RuntimeException("Can't add information to storage, information is empty: "
                + fruit);
    }

    @Override
    public List<FruitTransaction> getAll() {
        if (!Storage.getDataStorage().isEmpty()) {
            return Storage.getDataStorage();
        }
        throw new RuntimeException("Storage is empty");
    }

    @Override
    public FruitTransaction getBalance(FruitTransaction fruitTransaction) {
        return Storage.getDataStorage().stream()
                .filter(fruit -> fruit.getFruit()
                        .equals(fruitTransaction.getFruit())
                        && fruit.getOperation()
                        .equals(FruitTransaction.Operation.BALANCE))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find any of balance"));
    }

}
