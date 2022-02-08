package core.basesyntax.services;

import core.basesyntax.services.handlers.FruitHandler;

public interface FruitStrategy {
    FruitHandler getHandler(String typeOperation);
}
