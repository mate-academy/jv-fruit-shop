package core.basesyntax.services;

import core.basesyntax.services.handlers.FruitHandler;
import java.util.HashMap;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private final Map<String, FruitHandler> choiceOperation = new HashMap<>();

    @Override
    public Map<String, FruitHandler> create() {
        return choiceOperation;
    }
}
