package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class LocalStorage {
    public static final List<FruitTransaction> FRUIT_TRANSACTIONS = new ArrayList<>();

    private LocalStorage() {
    }
}
