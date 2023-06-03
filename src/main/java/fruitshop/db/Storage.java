package fruitshop.db;

import fruitshop.model.FruitTransaction;
import fruitshop.strategy.impl.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<FruitTransaction, OperationStrategy> fruits = new HashMap<>();
}
