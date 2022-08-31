package core.basesyntax.service.strategy;

import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.handlers.ActivityHandler;
import core.basesyntax.service.strategy.maps.TypeActivityToOperation;

public class TypeActivityStrategyImpl implements TypeActivityStrategy {
    private final TypeActivityToOperation typeActivityToOperation;

    public TypeActivityStrategyImpl(TypeActivityToOperation typeActivityToOperation) {
        this.typeActivityToOperation = typeActivityToOperation;
    }

    @Override
    public ActivityHandler getHandlerByTypeActivity(TypeActivity typeActivity) {
        return typeActivityToOperation.getMap().get(typeActivity);
    }
}
