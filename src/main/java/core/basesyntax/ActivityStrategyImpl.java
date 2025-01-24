package core.basesyntax;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.models.activities.ActivityHandler;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<FruitTransaction.TypeOfActivity, ActivityHandler> handlerMap;

    public ActivityStrategyImpl(Map<FruitTransaction.TypeOfActivity, ActivityHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public ActivityHandler getActivity(FruitTransaction.TypeOfActivity type) {
        return handlerMap.get(type);
    }
}
