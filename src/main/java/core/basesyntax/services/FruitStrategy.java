package core.basesyntax.services;

import core.basesyntax.services.handlers.FruitHandler;
import java.util.Map;

public interface FruitStrategy {
    Map<String, FruitHandler> create();
}
