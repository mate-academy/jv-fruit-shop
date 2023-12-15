package core.basesyntax.strategy;

import core.basesyntax.models.FruitTransaction;
import java.util.Map;

public class FruitDistributionStrategyImpl implements FruitDistributionStrategy {
    private final Map<FruitTransaction.Operation, ShopActivities> shopActivitiesMap;

    public FruitDistributionStrategyImpl(Map<FruitTransaction.Operation,
            ShopActivities> shopActivitiesMap) {
        this.shopActivitiesMap = shopActivitiesMap;
    }

    @Override
    public ShopActivities getActivity(FruitTransaction.Operation operationType) {
        return shopActivitiesMap.get(operationType);
    }
}
