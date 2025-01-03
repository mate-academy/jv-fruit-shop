package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Map<String, FruitTransaction> calculatedTransactions = new HashMap<>();

    public static List<FruitTransaction> getFruitTransactionList() {
        return calculatedTransactions.values().stream().toList();
    }

    public static Map<String, FruitTransaction> getCalculatedTransactions() {
        return calculatedTransactions;
    }
}
