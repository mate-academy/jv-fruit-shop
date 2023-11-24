package core.basesyntax.db;

import model.FruitStorage;
import model.FruitTransactionStorage;

public interface CommandDao {
    FruitTransactionStorage read();

    void write(FruitStorage content);
}
