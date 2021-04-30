package core.basesyntax.activity;

import core.basesyntax.storage.dao.HandleGoods;

import java.util.Map;

public class ActivityStrategyImpl implements PickActivityStrategy {
    private final Map<Activities, HandleGoods> handleGoodsMap;

    public ActivityStrategyImpl(Map<Activities, HandleGoods> handleGoodsMap) {
        this.handleGoodsMap = handleGoodsMap;
    }

    @Override
    public HandleGoods get(Activities activities) {
        return handleGoodsMap.get(activities);
    }

}
