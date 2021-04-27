package core.basesyntax.store;

import core.basesyntax.store.strategy.TypeHandler;

public interface TypeStrategy {
    TypeHandler get(String type);
}
