package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage {
    public Map<String, Integer> createStorage(List<FruitTransaction> transactions) {
        return transactions.stream().map(f -> f.getFruit().getName())
                .distinct()
                .collect(Collectors.toMap(obj -> obj, obj -> 0));
    }
}
