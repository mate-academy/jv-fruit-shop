package core.basesyntax.dao.storagedao;

import core.basesyntax.dao.transaction.FruitTransaction;
import core.basesyntax.db.FruitStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        FruitStorage.fruitDB.add(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getAllTransaction() {
        return new ArrayList<>(FruitStorage.fruitDB);
    }
}
