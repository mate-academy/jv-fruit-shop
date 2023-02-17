package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.strategy.ActivitiesShop;
import core.basesyntax.strategy.ActivitiesStrategy;
import java.util.List;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<TypeActivity, ActivitiesShop> operationsShopMap;

    public ActivitiesStrategyImpl(Map<TypeActivity, ActivitiesShop> operationsShopMap) {
        this.operationsShopMap = operationsShopMap;
    }

    @Override
    public void operation(List<FruitOperation> fruitOperations) {
        for (FruitOperation fruit : fruitOperations) {
            ActivitiesShop activitiesShop = operationsShopMap.get(fruit.getTypeActivity());
            activitiesShop.calculate(fruit);
        }
    }
}
