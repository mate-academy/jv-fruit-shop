package core.basesyntax.strategy;

import core.basesyntax.service.activity.ActivityOperation;
import core.basesyntax.service.activity.TypeActivity;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<TypeActivity, ActivityOperation> handlerMap;

    public ActivityStrategyImpl(Map<TypeActivity, ActivityOperation> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public ActivityOperation get(TypeActivity type) {
        return handlerMap.get(type);
    }
}
