package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import java.util.HashMap;
import java.util.Map;

public class StrategySupplierImpl implements StrategySupplier {
    private final Map<String, OperationStrategy> strategys = new HashMap<>();

    public StrategySupplierImpl(FruitDao fruitDao) {
        strategys.put("b", new SetQuantityStrategy(fruitDao));
        strategys.put("s", new IncreaseQuantityStrategy(fruitDao));
        strategys.put("p", new ReduceQuantityStrategy(fruitDao));
        strategys.put("r", new IncreaseQuantityStrategy(fruitDao));
    }

    public OperationStrategy getStrategy(String operation) {
        return strategys.get(operation);
    }
}
