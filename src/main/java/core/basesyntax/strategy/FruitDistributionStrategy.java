package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransition;

public interface FruitDistributionStrategy {
    ShopActivities getActivity(FruitTransition.Operation operationType);
}
