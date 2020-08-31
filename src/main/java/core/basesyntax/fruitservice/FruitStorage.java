package core.basesyntax.fruitservice;

import java.util.ArrayList;
import java.util.List;

public class FruitStorage {
    private static final List<Transaction> storage = new ArrayList<>();

    public List<Transaction> getStorage() {
        return storage;
    }
}
