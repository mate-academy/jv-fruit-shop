package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.operation.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public final static Map<Fruit, Integer> fruitStorage = new HashMap<>();
}
