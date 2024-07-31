package core.basesyntax.db;

import core.basesyntax.domain.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<FruitTransaction.FruitName, Integer>
            fruitTransactions = new HashMap<>();

    public static Map<FruitTransaction.FruitName, Integer> getFruitTransactions() {
        return fruitTransactions;
    }
}
