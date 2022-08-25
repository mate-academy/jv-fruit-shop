package core.basesyntax.storage;

import core.basesyntax.model.Fruit;

import java.util.Map;

public abstract class Storage<T> {
    protected Map<T, Integer> productBalance;
}
