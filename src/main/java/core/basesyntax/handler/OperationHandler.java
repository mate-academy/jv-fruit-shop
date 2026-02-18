package core.basesyntax.handler;

import core.basesyntax.*;

import java.util.*;

public interface OperationHandler {
    public void handle(FruitTransaction transaction, Map<String, Integer> storage);
}
