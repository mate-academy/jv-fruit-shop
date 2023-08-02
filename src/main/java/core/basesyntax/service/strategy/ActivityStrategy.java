package core.basesyntax.service.strategy;

import core.basesyntax.model.Fruit;

public interface ActivityStrategy {
    ActivityHandler getQuantityModifier(Fruit.Operation operation);
}
