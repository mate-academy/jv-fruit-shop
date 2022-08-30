package core.basesyntax.strategy.impl;

import core.basesyntax.model.MovementType;
import core.basesyntax.strategy.GoodHandler;
import core.basesyntax.strategy.Strategy;
import java.util.Map;

public class PostingStrategy implements Strategy {
    private final Map<MovementType, GoodHandler> handlerMap;

    public PostingStrategy(Map<MovementType, GoodHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public GoodHandler getHandlerForMovement(MovementType type) {
        return handlerMap.get(type);
    }
}
