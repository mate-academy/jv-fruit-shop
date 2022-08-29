package core.basesyntax.service.strategy;

import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.handlers.ActivityHandler;
import java.util.Map;

public class TypeActivityStrategyImpl implements TypeActivityStrategy {
    private final Map<TypeActivity, ActivityHandler> map;

    public TypeActivityStrategyImpl(Map<TypeActivity, ActivityHandler> map) {
        this.map = map;
    }

    @Override
    public ActivityHandler get(TypeActivity typeActivity) {
        return map.get(typeActivity);
    }
}
