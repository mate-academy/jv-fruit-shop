package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransaction;

public interface FruitDistributionStrategy {
    ShopActivities getActivity(FruitTransaction.Operation operationType);
}
