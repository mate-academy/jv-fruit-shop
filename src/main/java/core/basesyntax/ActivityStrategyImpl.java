package core.basesyntax;

import core.basesyntax.models.Fruit;
import core.basesyntax.models.activities.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<Fruit.TypeOfActivity, ActivityHandler> handlerMap;

    public ActivityStrategyImpl(Map<Fruit.TypeOfActivity, ActivityHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public ActivityHandler getActivity(Fruit.TypeOfActivity type) {
        return handlerMap.get(type);
    }
}
