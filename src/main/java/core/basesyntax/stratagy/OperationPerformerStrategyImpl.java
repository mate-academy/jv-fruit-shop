package core.basesyntax.stratagy;

import core.basesyntax.SetUp;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationPerformerStrategyImpl implements OperationPerformerStrategy {
    private Map<FruitTransaction.Operation, OperationPerformer> performers =
            new SetUp().initPerformers();

    @Override
    public OperationPerformer getOperationPerformer(FruitTransaction.Operation operation) {
        return performers.get(operation);
    }
}
