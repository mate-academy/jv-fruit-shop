package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Storage {
    void set(List<FruitTransaction> transactions);

    List<FruitTransaction> get();
}
