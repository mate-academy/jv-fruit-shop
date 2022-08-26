package core.basesyntax.strategy.impl;

import core.basesyntax.model.MovementType;
import core.basesyntax.strategy.GoodHandler;
import core.basesyntax.strategy.Strategy;
import java.util.Map;

public class PostingStrategy implements Strategy {
    private final Map<MovementType, GoodHandler> strategies;

    public PostingStrategy(Map<MovementType, GoodHandler> strategies) {
        this.strategies = strategies;
    }

    public GoodHandler getPostingAccordingMovement(MovementType type) {
        return strategies.get(type);
    }
}
