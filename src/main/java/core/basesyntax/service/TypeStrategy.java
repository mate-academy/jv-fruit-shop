package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.TypeHandler;

public interface TypeStrategy {
    TypeHandler getStrategy(Fruit.Type type);
}
