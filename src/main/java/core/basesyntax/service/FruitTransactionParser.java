package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

@FunctionalInterface
public interface FruitTransactionParser<T> {
    FruitTransaction parse(T value);
}
