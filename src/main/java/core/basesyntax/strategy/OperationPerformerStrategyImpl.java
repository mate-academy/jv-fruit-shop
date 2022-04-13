package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationPerformerStrategyImpl implements OperationPerformerStrategy {
    private final Map<FruitTransaction.Operation, OperationPerformer> performers;

    public OperationPerformerStrategyImpl(Map<FruitTransaction.Operation,
            OperationPerformer> performers) {
        this.performers = performers;
    }

    @Override
    public OperationPerformer getOperationPerformer(FruitTransaction.Operation operation) {
        return performers.get(operation);
    }
}
