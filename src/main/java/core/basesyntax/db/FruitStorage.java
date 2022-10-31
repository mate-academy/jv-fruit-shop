package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FruitStorage {
    private final List<FruitTransaction> storage;

    public FruitStorage() {
        this.storage = new ArrayList<>();
    }

    public List<FruitTransaction> getStorage() {
        return storage;
    }
}
