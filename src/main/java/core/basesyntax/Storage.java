package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    public static Map<String, FruitTransaction> calculatedTransactions = new HashMap<>();

    public static List<FruitTransaction> getFruitTransactionList() {
        return calculatedTransactions.values().stream().collect(Collectors.toList());
    }
}
