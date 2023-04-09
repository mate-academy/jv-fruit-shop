package core.basesyntax.function.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DailyBalanceToFruitTransactionList
        implements Function<Map<String, Integer>, List<FruitTransaction>> {
    @Override
    public List<FruitTransaction> apply(Map<String, Integer> fruitQuantities) {
        return fruitQuantities.entrySet()
                .stream()
                .map(entry -> new FruitTransaction(
                        "b",
                        entry.getKey(),
                        String.valueOf(entry.getValue())
                ))
                .collect(Collectors.toList());
    }
}
