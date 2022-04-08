package core.basesyntax.stratagy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CommandService;
import java.util.Map;

public class OperationPerformerStrategyImpl implements OperationPerformerStrategy {
    private Map<FruitTransaction.Operation, OperationPerformer> performers =
            new CommandService().initPerformers();

    @Override
    public OperationPerformer getOperationPerformer(FruitTransaction.Operation operation) {
        return performers.get(operation);
    }
}
