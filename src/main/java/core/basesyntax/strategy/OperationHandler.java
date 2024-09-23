package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;

public interface OperationHandler {
    void handle(HashMap<String, Integer> storage, FruitTransaction transaction);
}
