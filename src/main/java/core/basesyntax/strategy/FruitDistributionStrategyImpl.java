package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransition;
import java.util.Map;

public class FruitDistributionStrategyImpl implements FruitDistributionStrategy {
    private final Map<FruitTransition.Operation, ShopActivities> shopActivitiesMap;

    public FruitDistributionStrategyImpl(Map<FruitTransition.Operation,
            ShopActivities> shopActivitiesMap) {
        this.shopActivitiesMap = shopActivitiesMap;
    }

    @Override
    public ShopActivities getActivity(FruitTransition.Operation operationType) {
        return shopActivitiesMap.get(operationType);
    }
}
