package core.basesyntax.infratructure.db;

import core.basesyntax.service.FruitOperationsSupplier;

public interface InsertListDao {
    void writeInfo(FruitOperationsSupplier.Operation operation, String fruitName, int amount);
}
