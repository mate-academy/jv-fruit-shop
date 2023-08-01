package core.basesyntax.service.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ActivitiesService;

public interface ActivityStrategy {
    ActivitiesService getQuantityModifier(Fruit.Operation operation);
}
