package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface FruitTransactionParser<T> {
    FruitTransaction parse(T value);

    default List<FruitTransaction> parse(List<T> values) {
        return values.stream()
                .map(t -> parse(t))
                .collect(Collectors.toList());
    }
}
