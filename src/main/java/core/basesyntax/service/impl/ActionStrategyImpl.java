package core.basesyntax.service.impl;

import core.basesyntax.service.ActionStrategy;
import core.basesyntax.service.actiontype.ActionType;
import java.util.Map;

public class ActionStrategyImpl implements ActionStrategy {
    private Map<String, ActionType> mapStrategy;

    public ActionStrategyImpl(Map<String, ActionType> mapStrategy) {
        this.mapStrategy = mapStrategy;
    }

    @Override
    public ActionType get(String type) {
        return mapStrategy.get(type);
    }
}
