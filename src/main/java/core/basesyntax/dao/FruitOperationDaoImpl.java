package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitOperation;
import java.util.List;

public class FruitOperationDaoImpl implements FruitOperationDao {
    @Override
    public void add(FruitOperation fruitOperation) {
        Storage.fruitsOperationsStorage.add(fruitOperation);
    }

    @Override
    public FruitOperation get(FruitOperation fruitOperation) {
        return Storage.fruitsOperationsStorage.stream()
                .filter(currFruitOperation -> currFruitOperation.equals(fruitOperation))
                .findFirst()
                .get();
    }

    @Override
    public List<FruitOperation> getAll() {
        return Storage.fruitsOperationsStorage;
    }
}
