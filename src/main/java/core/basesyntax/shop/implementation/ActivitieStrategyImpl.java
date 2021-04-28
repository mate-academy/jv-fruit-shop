package core.basesyntax.shop.implementation;

import core.basesyntax.handlers.Activitie;
import core.basesyntax.shop.ActivitieStrategy;
import java.util.Map;

public class ActivitieStrategyImpl implements ActivitieStrategy {
    private Map<String, Activitie> activitieMap;

    public ActivitieStrategyImpl() {
        activitieMap = new HandlerMap().getHandlerMap();
    }

    @Override
    public Activitie get(String action) {
        return activitieMap.get(action.toUpperCase());
    }
}
