package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.strategy.impl.AddBiFunction;
import core.basesyntax.strategy.impl.SubtractBiFunction;
import java.util.Map;
import java.util.function.ToIntBiFunction;

public class BiFunctionSupplier {
    private Map<Operation, ToIntBiFunction<Integer, Integer>> operations;

    public BiFunctionSupplier() {
        this.operations = Map.of(Operation.RETURN, new AddBiFunction(),
                Operation.SUPPLY, new AddBiFunction(),
                Operation.PURCHASE, new SubtractBiFunction());
    }

    public ToIntBiFunction<Integer, Integer> getFunction(Operation operation) {
        return operations.get(operation);
    }
}
