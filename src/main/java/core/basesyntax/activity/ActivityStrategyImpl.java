package core.basesyntax.activity;

import core.basesyntax.storage.dao.StorageHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<Activities, StorageHandler> handleGoodsMap;

    public ActivityStrategyImpl(Map<Activities, StorageHandler> handleGoodsMap) {
        this.handleGoodsMap = handleGoodsMap;
    }

    @Override
    public StorageHandler get(Activities activities) {
        return handleGoodsMap.get(activities);
    }

}
