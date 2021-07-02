package core.basesyntax.model.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategySupplier {
    private final Map<String, OperationStrategy> strategys = new HashMap<>();

    {
        strategys.put("b", new SetQuantityStrategy());
        strategys.put("s", new IncreaseQuantityStrategy());
        strategys.put("p", new ReduceQuantityStrategy());
        strategys.put("r", new IncreaseQuantityStrategy());
    }

    public OperationStrategy getStrategy(String operation) {
        return strategys.get(operation);
    }
}
