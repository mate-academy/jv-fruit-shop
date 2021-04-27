package core.basesyntax.activity;

import core.basesyntax.managing.storage.HandleGoods;
import java.util.Map;

public class ActivityStrategyImpl implements PickActivityStrategy {
    private Map<Activities, HandleGoods> handleGoodsMap;

    public ActivityStrategyImpl(Map<Activities, HandleGoods> handleGoodsMap) {
        this.handleGoodsMap = handleGoodsMap;
    }

    public Map<Activities, HandleGoods> getHandleGoodsMap() {
        return handleGoodsMap;
    }

    public void setHandleGoodsMap(Map<Activities, HandleGoods> handleGoodsMap) {
        this.handleGoodsMap = handleGoodsMap;
    }

    @Override
    public HandleGoods get(Activities activities) {
        return handleGoodsMap.get(activities);
    }

}
