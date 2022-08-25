package core.basesyntax.service;

import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private final Map<TypeActivity, ActivityHandler> map;

    public ActivityStrategyImpl(Map<TypeActivity, ActivityHandler> map) {
        this.map = map;
    }

    @Override
    public ActivityHandler get(TypeActivity typeActivity) {
        return map.get(typeActivity);
    }
}
