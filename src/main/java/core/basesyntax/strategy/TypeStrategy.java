package core.basesyntax.strategy;

import core.basesyntax.strategy.type.TypeHandlers;

public interface TypeStrategy {
    TypeHandlers get(Character type);
}
