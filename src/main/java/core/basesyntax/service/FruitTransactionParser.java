package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

@FunctionalInterface
public interface FruitTransactionParser<T> {
    FruitTransaction parse(T value);
}
